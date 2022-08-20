package com.NAGP.Calalogue.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.NAGP.Calalogue.services.ItemService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/catalogue")
@EnableCircuitBreaker
public class Controller {
	
	@Value("${server.port}")
	private int port;
	final String service = "Catalogue port :";
	
	@Resource
	ItemService itemService;

	@GetMapping(value = "/items")
	public String getItems() {
		System.out.println(service + port );
		return itemService.getAllItems();
	}

	
	@GetMapping(value = "/placeorder/{itemID}")
	public String placeOrder(@PathVariable(name = "itemID") String itemID) {
		return itemService.placeOrder(itemID);
	}
	
	@GetMapping(value = "/order/{orderID}")
	public String getPriceForProduct(@PathVariable(name = "orderID") String orderID) {
		return itemService.getStatus(orderID);
	}
	

}
