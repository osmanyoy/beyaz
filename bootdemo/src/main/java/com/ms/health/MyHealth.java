package com.ms.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

	@Override
	public Health health() {
		MyStatus myStatus = new MyStatus();
		myStatus.setCause(100);
		myStatus.setDesc("asjhdhsadgsa");
		myStatus.setExtra("extra");
		myStatus.setMextra("Mex");
		return Health.down().withDetail("error",
		                                myStatus)
		        .build();
	}

}
