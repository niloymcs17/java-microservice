package com.NAGP.ServiceProviders.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.NAGP.ServiceProviders.database.Data;
import com.NAGP.ServiceProviders.model.Providers;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class ServiceImpl {

	static HashMap<String, Providers> providerDB=new HashMap<String, Providers>();
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Resource
	Data idata;
	
	@HystrixCommand(fallbackMethod = "orderDown")
	public String getJobs(String serviceID) {
		String response = "";
		if(providerDB.isEmpty()) {
			providerDB = idata.getProviders();
		}
		if(providerDB.containsKey(serviceID)) {
			String url = "order/jobs/" + serviceID ;
			try {
				InstanceInfo instance = eurekaClient.getNextServerFromEureka("order", false);
				response = restTemplate.getForObject(instance.getHomePageUrl() + url, String.class);
			} catch (Exception e) {
				response = "Ordering service is not available right now.";
			}
		} else {
			response = "Invalid Service ID";
		}
		return response;
	}
	
//	fallback code for order service	
	public String orderDown(String serviceID) {
		return "Order service is down we will be back soon!!";
	}
	
//	fallback code for order service	
	public String orderDown(String orderID ,String serviceID) {
		return "Order service is down we will be back soon, accepting order failed!!";
	}
	
	@HystrixCommand(fallbackMethod = "orderDown")
	public String accept(String orderID , String serviceID) {
		// TODO Auto-generated method stub
		String response = "";
		String url = "order/accept/"+orderID +"/" + serviceID ;
		try {
			InstanceInfo instance = eurekaClient.getNextServerFromEureka("order", false);
			response = restTemplate.getForObject(instance.getHomePageUrl() + url, String.class);
		} catch (Exception e) {
			response = "Ordering service is not available right now.";
		}
		return response;
	}
}
