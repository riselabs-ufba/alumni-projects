package com.she.core.driver.water;

import org.json.JSONObject;

public class WaterSensor extends Sensor {

	public WaterSensor(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transformation(JSONObject value) {
		// TODO Auto-generated method stub
				
		return value.toString();
	}

}
