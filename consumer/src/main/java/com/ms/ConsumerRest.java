package com.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ConsumerRest {

	@Autowired
	private RestTemplate rt;

	@Autowired
	private EurekaClient ec;

	@GetMapping("/test2")
	public MyStatus getStatus2() {
		ResponseEntity<MyStatus> status = this.rt.getForEntity("http://BOOTDEMO/status",
		                                                       MyStatus.class);
		return status.getBody();
	}

	@GetMapping("/test")
	public MyStatus getStatus() {
		InstanceInfo nextServerFromEureka = this.ec.getNextServerFromEureka("bootdemo",
		                                                                    false);
		ResponseEntity<MyStatus> status = this.rt.getForEntity(nextServerFromEureka.getHomePageUrl() + "/status",
		                                                       MyStatus.class);
		return status.getBody();
	}

}
