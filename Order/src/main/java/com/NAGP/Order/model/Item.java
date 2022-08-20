package com.NAGP.Order.model;

public class Item {

	String itemId;
	String jobDescription;
	String type;
	int price;
	
	public Item(String itemId, String jobDescription, String type, int price) {
		super();
		this.itemId = itemId;
		this.jobDescription = jobDescription;
		this.type = type;
		this.price = price;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", jobDescription=" + jobDescription + ", type=" + type + ", price=" + price
				+ "]";
	}
	
	public String itemTypeString() {
		return "[itemId=" + itemId + ", type=" + type + ", price=" + price+ "] <br>";
	}
	
}
