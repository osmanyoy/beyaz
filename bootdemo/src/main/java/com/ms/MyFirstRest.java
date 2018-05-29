package com.ms;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.health.MyStatus;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MyFirstRest {

	@Value("${my.test}")
	private String str;

	@GetMapping("testconfig")
	public String testConfig() {
		return this.str;
	}

	@GetMapping("/hello/{isim}")
	// @RequestMapping(path="/hello/{isim}",method=RequestMethod.HEAD)
	public String hello(@PathVariable("isim") String name,
	                    @RequestParam("soy") String surname) {
		return "Hello World : " + name + " " + surname;
	}

	@GetMapping("/status")
	public MyStatus getMyStatus() {
		MyStatus myStatus = new MyStatus();
		myStatus.setCause(100);
		myStatus.setDesc("asjhdhsadgsa");
		myStatus.setExtra("extra");
		myStatus.setMextra("Mex");
		return myStatus;
	}

	@PostMapping("/test")
	@ApiOperation(notes = "Deneme notu", response = MyStatus.class, value = "Deneme Operasyon desc")
	@ApiResponses({ @ApiResponse(code = 201, message = "Deneme mesajı") })
	public ResponseEntity<?> getMyStatus(@Valid @RequestBody MyStatus myStatus) {
		return ResponseEntity.status(HttpStatus.CREATED)
		                     .body(myStatus);
	}

}
