package com.she.sensors;

public abstract class Sensor {
	private String name;
	private String value;
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
	public void setValue(String value) {
		this.value = value;
	}
	
	public abstract String transformation(String value);
	
	
}
