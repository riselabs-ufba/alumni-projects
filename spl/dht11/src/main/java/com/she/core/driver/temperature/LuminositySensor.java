package com.she.core.driver.temperature;

public class LuminositySensor extends Sensor {

	public LuminositySensor(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transformation(String value) {
		// TODO Auto-generated method stub
//		Convert value to lumis
		float lumis = Float.valueOf(value); 
		lumis = (float) ( lumis*(5.0/1024.0));
		lumis = (float) (( ( 2500.0 / lumis ) - 400.0)/2.0);
				
		return String.valueOf(lumis);
	}

}
