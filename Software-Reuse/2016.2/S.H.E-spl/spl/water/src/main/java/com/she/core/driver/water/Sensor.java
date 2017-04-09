package com.she.core.driver.water;

import org.json.JSONObject;

public abstract class Sensor {
	private String name;
	private JSONObject value;
	private String type;
	public Sensor(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
		
	public String getValue() {
		return transformation(value);
	}
	public void setValue(JSONObject value) {
		this.value = value;
	}
	
	public abstract String transformation(JSONObject value);
	
	
}
