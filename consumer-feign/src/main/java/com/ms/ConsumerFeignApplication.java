package com.ms;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableRabbit
@RestController
public class ConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication.class,
		                      args);
	}

	@Autowired
	private RabbitTemplate rt;

	@Autowired
	private IMyRest mr;

	@GetMapping("/feign")
	public MyStatus testFeign() {
		return this.mr.getMyStatus();
	}

	@GetMapping("/rabbit/{msg}")
	public String testRabbit(@PathVariable("msg") String str) {
		this.rt.convertAndSend("myexchange1",
		                       "testkey",
		                       str);
		return "OK";
	}

}
