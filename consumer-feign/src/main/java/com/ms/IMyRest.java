package com.ms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "bootdemo")
public interface IMyRest {

	@GetMapping("/status")
	public MyStatus getMyStatus();

	@GetMapping("testconfig")
	public String testConfig();

	@GetMapping("/hello/{isim}")
	public String hello(@PathVariable("isim") String name,
	                    @RequestParam("soy") String surname);

	@PostMapping("/test")
	public ResponseEntity<?> getMyStatus(@RequestBody MyStatus myStatus);
}
