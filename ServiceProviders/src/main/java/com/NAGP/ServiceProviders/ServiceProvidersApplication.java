package com.NAGP.ServiceProviders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProvidersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProvidersApplication.class, args);
	}

	@Bean(name = "restTemp")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
