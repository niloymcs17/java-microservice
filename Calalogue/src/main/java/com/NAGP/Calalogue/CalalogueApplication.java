package com.NAGP.Calalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CalalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalalogueApplication.class, args);
	}
	@Bean(name = "restTemp")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
