package com.she.manager;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;

public class Manager {
	private String command = "/home/ramon/Downloads/apache/apache-karaf-4.0.8/bin/client ";
	private ArrayList<String> devices = new ArrayList<String>();
	public Manager() {
		
		// TODO Auto-generated constructor stub
	}
	public void callComand(JSONObject json) throws Exception{
		String type = json.getString("typeDevice");
		if (type == "Sensor") {
			
			/*
			 *  If the device is nor registered yet
			 *  Add to the devices list  
			 */
			if (!devices.contains(json.getString("name"))) {
				devices.add(json.getString("name"));
			}
			
			
		} else if (type == "generator") {
			iterativeStatusSet(json.getJSONObject("list"));			
		} else if (type == "list") {
			
		}
		
	}
	public void name() {
		
	}
	public void iterativeStatusSet(JSONObject json) throws Exception {		
		Iterator<?> keys = json.keys();

		while( keys.hasNext() ) {
		    String key = (String)keys.next();
		    setBundleStatus(json.getBoolean(key), key);

		}
	}
	private void setBundleStatus(boolean status, String bundleName) throws Exception {
		// TODO Auto-generated method stub
		Process p;
		if (status){
			Runtime.getRuntime().exec(command + "start " + bundleName).waitFor();
//			p.waitFor();
			System.out.println(command + "start " + bundleName);
		} else {
			Runtime.getRuntime().exec(command + "stop " + bundleName);
//			p.waitFor();
			System.out.println(command + "stop " + bundleName);
		}
	}
}
