package com.example.application;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/get")
@EnableHystrix
public class Details {
	@GetMapping("/name")
	public String user() {
		return "ajay";
	}

	@GetMapping(value = "/hystrix")
	@HystrixCommand(fallbackMethod = "fallBackHello", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String hello() throws InterruptedException {
		Thread.sleep(3000);
		return "Welcome Hystrix";
	}

	private String fallBackHello() {
		return "Request fails. It takes long time to response";
	}
}
