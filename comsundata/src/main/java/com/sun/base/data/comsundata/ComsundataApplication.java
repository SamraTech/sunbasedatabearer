package com.sun.base.data.comsundata;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class ComsundataApplication {

	public static void main(String[] args) {
		System.out.println("Hi");
		SpringApplication.run(ComsundataApplication.class, args);
	}
	


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();

	}
}
