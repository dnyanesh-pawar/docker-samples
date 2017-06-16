package com.example.springboot.userapp.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@SpringBootApplication
public class UserAppConsumer {

	public static void main(String[] args) {
		SpringApplication.run(UserAppConsumer.class, args);
	}
	
	
	@LoadBalanced // ribbon
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
