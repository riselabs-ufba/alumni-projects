package com.she.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.json.JSONObject;

import com.she.manager.MqttListener;

public class ManagerMqttListener extends MqttListener{
	MqttClient client;
	Manager manager = new Manager();
	
	private String command = "/home/ramon/Downloads/apache/apache-karaf-4.0.8/bin/client ";
	private ArrayList<JSONObject> devices = new ArrayList<JSONObject>();

/*
 * (non-Javadoc)
 * @see com.she.manager.MqttListener#messageArrived(java.lang.String, org.eclipse.paho.client.mqttv3.MqttMessage)
 * 
 * It changes the callback(messageArrived) to achieve the manager specific behavior
 */
	@Override
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
//		manager.iterativeStatusSet(new JSONObject(arg1.toString()));
//		publish(arg1.toString());
		callComand(new JSONObject(arg1.toString()));
	}
	
	public void callComand(JSONObject json) throws Exception{
		String type = json.getString("typeDevice");
		if (type.equals("Sensor")) {
			
			/*
			 *  If the device is nor registered yet
			 *  Add to the devices list  
			 */
			boolean contains = false;
			for (JSONObject device: devices) {
				if (json.getString("name") == device.getString("name") ) {
					contains = true;
				}
			}
			if (!contains) {
				devices.add(json);
			}
			publish("Sensor", "screen");
		} else if (type.equals("generator")) {
			iterativeStatusSet(json.getJSONObject("list"));
			publish("generator", "screen");
		} else if (type.equals("list")) {
//			publish("Lista!!", "screen");
			publish(devices.toString(), "screen");
		} else {
			System.out.println("Retorno!");
//			publish("nem foi: " + type + "Sensor", "connections");
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
