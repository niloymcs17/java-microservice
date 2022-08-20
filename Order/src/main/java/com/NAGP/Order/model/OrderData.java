package com.NAGP.Order.model;

public class OrderData {

	String itemId;
	String orderId;
	String status = "PROCESSING";
	String serviceProvider = "";
	String jobDescription;
	public OrderData(String itemId, String orderId, String jobDescription) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
		this.jobDescription = jobDescription;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	@Override
	public String toString() {
		return "OrderData [itemId=" + itemId + ", orderId=" + orderId + ", status=" + status + ", serviceProvider="
				+ serviceProvider + ", jobDescription=" + jobDescription + "]";
	}
	
	public String forCustomer() {
		return "Your orderId is " + orderId + ",and status=" + status;
	}
	
	public String forServiceProvider() {
		return "Your jobDescription is " + jobDescription ;
	}

}
