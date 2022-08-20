package com.NAGP.Order.model;

public class Providers {

	String providerId;
	boolean availablity = true;
	String type ;
	public Providers(String providerId, String type) {
		super();
		this.providerId = providerId;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Providers [providerId=" + providerId + ", availablity=" + availablity + ", type=" + type + "]";
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public boolean isAvailablity() {
		return availablity;
	}
	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
