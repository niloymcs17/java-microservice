package com.NAGP.Order.Controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.NAGP.Order.service.OrderService;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(value = "/order")
@EnableCircuitBreaker
public class Controller {
	
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
	private int port;
	final String service = "order port :";
	
	@Resource
	OrderService orderService;

	@GetMapping(value = "/placeOrder")
	String getItems(@RequestParam(name = "itemID") String itemID) {
		System.out.println(service + port );
		
		return orderService.getOrderId(itemID);
	}
	
	@GetMapping(value = "/orderStatus/{orderId}")
	String getItemDetails(@PathVariable(name = "orderId") String orderId) {
		
		return orderService.getItemById(orderId);
	}
	
//	providers can accept an order by providing an order id
	@GetMapping(value = "/accept/{orderId}/{serviceID}")
	String acceptService(@PathVariable(name = "orderId") String orderId,
			@PathVariable(name = "serviceID") String serviceID ) {
		System.out.println("accept order"+service + port );
		return orderService.acceptOrder(orderId, serviceID);
	}
	
//	for service providers to get list of order that he can accept
	@GetMapping(value = "/jobs/{serviceID}")
	String jobs(@PathVariable(name = "serviceID") String serviceID) {
		System.out.println(service + port );
		return orderService.getJobs(serviceID);
	}

}
