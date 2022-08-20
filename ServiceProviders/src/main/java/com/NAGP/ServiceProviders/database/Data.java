package com.NAGP.ServiceProviders.database;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.NAGP.ServiceProviders.model.Item;
import com.NAGP.ServiceProviders.model.Providers;


@Service
public class Data {

	static HashMap<String, Item> itemDB = new HashMap<String, Item>();
	static HashMap<String, Providers> ProvidersDB = new HashMap<String, Providers>();
	
	public HashMap<String, Item> getItem() {
		// TODO Auto-generated method stub
		Item temp = new Item("E01","Change lights","Electric",50);
		itemDB.put("E01", temp);
		temp = new Item("Y01","Change lights","yoga trainers",50);
		itemDB.put("Y01", temp);
		temp = new Item("I01","Change lights","interior designers",50);
		itemDB.put("I01", temp);
		temp = new Item("P01","Change lights","Plumbing",50);
		itemDB.put("P01", temp);
		temp = new Item("C01","Change lights","CCTV",50);
		itemDB.put("C01", temp);
		return itemDB;
	}
	public HashMap<String, Providers> getProviders() {
		// TODO Auto-generated method stub
		ProvidersDB.put("S01", new Providers("S01","Electric"));
		ProvidersDB.put("S02", new Providers("S02","interior designers"));
		ProvidersDB.put("S03", new Providers("S03","CCTV"));
		ProvidersDB.put("S04", new Providers("S04","Electric"));
		ProvidersDB.put("S05", new Providers("S05","Plumbing"));
		ProvidersDB.put("S06", new Providers("S06","Electric"));
		ProvidersDB.put("S07", new Providers("S07","yoga trainers"));
		ProvidersDB.put("S09", new Providers("S09","yoga trainers"));
		ProvidersDB.put("S10", new Providers("S10","Plumbing"));
		ProvidersDB.put("S11", new Providers("S11","Electric"));
		ProvidersDB.put("S12", new Providers("S12","CCTV"));
		ProvidersDB.put("S13", new Providers("S13","Electric"));
		ProvidersDB.put("S14", new Providers("S14","interior designers"));
		return ProvidersDB;
	}

}

