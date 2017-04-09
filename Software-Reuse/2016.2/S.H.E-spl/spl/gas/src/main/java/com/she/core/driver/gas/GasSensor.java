package com.she.core.driver.gas;

import org.json.JSONObject;

public class GasSensor extends Sensor {

	public GasSensor(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transformation(JSONObject value) {
		// TODO Auto-generated method stub
				
		return value.toString();
	}

}
