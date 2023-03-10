package com.example.application;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/get")
@EnableHystrix
public class Details {
	
//	@Scheduled(fixedDelay = 30)
	@GetMapping("/name")
	public String user() throws InterruptedException {
//		wait(300);
		Thread.sleep(360000);
		System.out.println("hello");
		return "success";
	}

//	@Scheduled(fixedDelay = 300)
	@GetMapping(value = "/hystrix")
//	@HystrixCommand(fallbackMethod = "fallBackHello", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "300") })
	public String hello() throws InterruptedException {
		Thread.sleep(240000);
//		wait(300);
		System.out.print("success");
		return "Welcome Hystrix";
	}

	private String fallBackHello() {
		return "Request fails. It takes long time to response";
	}
	
	
}
