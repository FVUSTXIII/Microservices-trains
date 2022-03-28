package com.mocktrainservice.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MockTrainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockTrainServiceApplication.class, args);
	}

}
