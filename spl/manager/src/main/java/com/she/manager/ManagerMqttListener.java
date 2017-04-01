package com.she.manager;

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

/*
 * (non-Javadoc)
 * @see com.she.manager.MqttListener#messageArrived(java.lang.String, org.eclipse.paho.client.mqttv3.MqttMessage)
 * 
 * It changes the callback(messageArrived) to achieve the manager specific behavior
 */
	@Override
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		manager.iterativeStatusSet(new JSONObject(arg1.toString()));
		publish(arg1.toString());
	}

	
}
