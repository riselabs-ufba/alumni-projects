package com.she.core.driver.temperature;

import org.json.JSONException;
import org.json.JSONObject;

public class TemperatureSensor extends Sensor {

	public TemperatureSensor(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transformation(JSONObject value) {
//		System.out.println("To transformando!");
		try {
//			System.out.println("Transfomei!");
			value.put("temperature", value.getLong("temperature") + "ºC");
			value.put("humidity", value.getLong("humidity") + "%");
			value.put("heatIndex", value.getLong("heatIndex") + "ºC");
			return value.toString();
//			return value.getString("temperature") + "ºC " + value.getString("humidity") + 
//					"% " + value.getString("heatIndex");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nem!");
		return "0";
	}

}
