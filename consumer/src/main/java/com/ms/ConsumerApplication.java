package com.ms;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication implements ApplicationRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class,
		                                                               args);
		ConsumerApplication bean = context.getBean(ConsumerApplication.class);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// ResponseEntity<MyStatus> forEntity =
		// this.restTemplate.getForEntity("http://127.0.0.1:9090/status",
		// MyStatus.class);
		// MyStatus body = forEntity.getBody();
		// System.out.println(body);
	}
}
