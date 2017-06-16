package com.example.springboot.edge.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class EdgeService {

	public static void main(String[] args) {
		SpringApplication.run(EdgeService.class, args);
	}
}
