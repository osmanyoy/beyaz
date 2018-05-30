package com.ms;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.SpringCloudBusClient;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableRabbit
@RestController
@RemoteApplicationEventScan
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class ConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication.class,
		                      args);
	}

	@Autowired
	@Output(SpringCloudBusClient.OUTPUT)
	private MessageChannel cloudBusOutboundChannel;

	@Autowired
	private RabbitTemplate rt;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private IMyRest mr;

	@GetMapping("/feign")
	public MyStatus testFeign() {
		return this.mr.getMyStatus();
	}

	@GetMapping("/event/{msg}")
	public String testEvet(@PathVariable("msg") String str) {
		MyRemoteEvent myRemoteEvent = new MyRemoteEvent(this, this.context.getId(), str);
		this.context.publishEvent(myRemoteEvent);
		this.cloudBusOutboundChannel.send(MessageBuilder.withPayload(myRemoteEvent)
		                                                .build());
		return "OK";
	}

	@GetMapping("/rabbit/{msg}")
	public String testRabbit(@PathVariable("msg") String str) {
		this.rt.convertAndSend("myexchange1",
		                       "testkey",
		                       str);
		return "OK";
	}

	private int count = 0;

	@GetMapping("/hello")
	@HystrixCommand(fallbackMethod = "helloFallback",
	                commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
	                                                     value = "500"))
	public String hello() {
		this.count++;
		// if ((this.count % 3) == 0) {
		// throw new IllegalArgumentException();
		// }
		if ((this.count % 4) == 0) {
			try {
				Thread.sleep(700);
			} catch (Exception e) {
			}
		}

		return "Hello World";
	}

	public String helloFallback() {
		return "Hello Fallback";
	}

}
