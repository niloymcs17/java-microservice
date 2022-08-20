package com.NAGP.Order.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.NAGP.Order.database.Data;
import com.NAGP.Order.model.Item;
import com.NAGP.Order.model.OrderData;
import com.NAGP.Order.model.Providers;

@Service
public class OrderService {
	
	//	local db for storing orders
	static HashMap<String, OrderData> orderDB = new HashMap<String, OrderData>();
	static HashMap<String, Item> itemDB = new HashMap<String, Item>();
	static HashMap<String, Providers> providerDB=new HashMap<String, Providers>();
	static HashMap<String, String> jobs=new HashMap<String, String>();
	
	@Resource
	Data idata;
	
	public String getOrderId(String itemID) {
		if(itemDB.isEmpty()) {
			itemDB = idata.getItem();
		}
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		String strDate = dateFormat.format(date);
		OrderData temp = new OrderData(itemID,strDate,(itemDB.get(itemID)).getJobDescription());
		createJobs((itemDB.get(itemID)).getType() , strDate);
		orderDB.put(strDate,temp);
		System.out.println(temp.getServiceProvider());
		return "Url for Order details is = /order/"+strDate+" ---"+temp.forCustomer();
	}

//	find service provider that provides this type of service
	private void createJobs(String type,String orderID){
		if(providerDB.isEmpty()) {
			providerDB = idata.getProviders();
		}
		providerDB.forEach((k,v) ->{
			if(type == v.getType()) {
				if(jobs.containsKey(k)) {
					String value = jobs.get(k) + ","+orderID;
					jobs.put(k, value);
				} else {
					jobs.put(k, orderID);
				}
			}
		});
	}

	public String getItemById(String orderId) {
		String response=" no such order placed";
		if(orderDB.containsKey(orderId)) {
			OrderData od= orderDB.get(orderId);
			response = od.forCustomer();
			if(od.getStatus() != "PROCESSING") {
				response += " And service provider assigned to you is "+od.getServiceProvider() ;
			}
		}
		return response;
	}


	public String acceptOrder(String orderId,String providerID) {
		if(orderDB.containsKey(orderId)) {
			OrderData od= orderDB.get(orderId);
			if(od.getStatus() == "PROCESSING") {
				od.setStatus("Confirmed");
				od.setServiceProvider(providerID);
				return "Your Job is -- "+od.getJobDescription();
			} else {
				String value = jobs.get(providerID);
				value = value.replace(orderId, "");
				return "Order is accepted by some other Provider!!";
			}
		} else {
			return "This order id not found!!";
		}
		
	}

	public String getJobs(String serviceID) {
		// TODO Auto-generated method stub
		if(jobs.containsKey(serviceID)) {
			return jobs.get(serviceID);
		} else {
			return "No jobs found for You!!";
		}
	}
	

}
