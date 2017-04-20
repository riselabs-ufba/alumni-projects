package com.she.core.driver.presence;

import org.json.JSONObject;

public class PresenceSensor extends Sensor {

	public PresenceSensor(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transformation(JSONObject value) {
		// TODO Auto-generated method stub
				
		return value.toString();
	}

}
