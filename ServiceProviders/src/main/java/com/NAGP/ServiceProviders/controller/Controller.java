package com.NAGP.ServiceProviders.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.NAGP.ServiceProviders.service.ServiceImpl;

@RestController
@RequestMapping(value = "/service")
@EnableCircuitBreaker
public class Controller {

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
	private int port;
	final String service = "service port :";
	
	@Resource
	ServiceImpl serviceImpl;
	
	
	@GetMapping(value = "/getTask/{serviceID}")
	String getItemDetails(@PathVariable(name = "serviceID") String serviceID) {
		
		return serviceImpl.getJobs(serviceID);
	}
	

	@GetMapping(value = "/accept/{orderID}/{serviceID}")
	String acceptOrder(@PathVariable(name = "orderID") String orderID,
			@PathVariable(name = "serviceID") String serviceID) {
		
		return serviceImpl.accept(orderID,serviceID);
	}
}
