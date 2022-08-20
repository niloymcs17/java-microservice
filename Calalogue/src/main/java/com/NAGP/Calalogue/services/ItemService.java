package com.NAGP.Calalogue.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.NAGP.Calalogue.models.Item;
import com.NAGP.Calalogue.database.Data;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ItemService {
	@Autowired
	private EurekaClient eurekaClient;

	static HashMap<String, Item> itemDB = new HashMap<String, Item>();
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	@Resource
	Data idata;
	
	public String getAllItems() {
		if(itemDB.isEmpty()) {
			itemDB = idata.getItem();
		}
		List<String> str =new ArrayList<String>();
		itemDB.forEach( (k,v) -> {
			str.add(v.itemTypeString());
		});
		System.out.println(str);
		return str.toString();
	}
	
	
	@HystrixCommand(fallbackMethod = "orderDown")
	public String placeOrder(String itemID) {
		String response = "";
		if(itemDB.isEmpty()) {
			itemDB = idata.getItem();
		}
		if(itemDB.containsKey(itemID)) {
			String url = "/order/placeOrder?itemID=" + itemID ;
			try {
				InstanceInfo instance = eurekaClient.getNextServerFromEureka("order", false);
				response = restTemplate.getForObject(instance.getHomePageUrl() + url, String.class);
			} catch (Exception e) {
				response = "Ordering service is not available right now.";
			}
		} else {
			response = "No Such Item exist";
		}
		return response;
	}
	
	@HystrixCommand(fallbackMethod = "orderDown")
	public String getStatus(String orderID) {
		String response = "";
			String url = "/order/orderStatus/" + orderID ;
			try {
				InstanceInfo instance = eurekaClient.getNextServerFromEureka("order", false);
				response = restTemplate.getForObject(instance.getHomePageUrl() + url, String.class);
			} catch (Exception e) {
				response = "Ordering service is not available right now.";
			}
		return response;
	}
	
//	fallback code for order service
	public String orderDown(String itemID) {
		return "Order service is down we will be back soon!!";
	}
	
}
