package com.she.manager;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class DefaultMqttListener extends MqttListener {
	MqttClient client;

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		// TODO Auto-generated method stub
//		publish("Follow-me " + arg1.toString());
		publish(arg1.toString());
//		System.out.println("Follow-me " + arg1.toString());
	}

	public MqttClient getClient() {
		return client;
	}

	public void setClient(MqttClient client) {
		this.client = client;
	}

	
//	The method for correctly publish
	public boolean publish(String messageString) {
//		This auxClient is a <workaround> to fix a <bug>!
		MqttClient auxClient;
//		System.out.println("Entrei");
		MqttMessage msg = new MqttMessage();
		String topic = "serviceChat";
		msg.setPayload(messageString.getBytes());
		auxClient = auxBuilder();
		try {
//			System.out.println("Publishing : " + messageString);
//			auxClient.publish(topic, ("Follow-me " + messageString).getBytes(), 0, false);
			auxClient.publish(topic, msg);
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			System.out.println("Persistence");
			e.printStackTrace();
		} catch (MqttException e) {
			System.out.println("Mqtt");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

//	This auxClient is a <workaround> to fix a <bug>!
	private MqttClient auxBuilder() {
		long unixTime = System.currentTimeMillis() / 1000L;
		MqttClient auxClient;
		MqttConnectOptions connOpt = new MqttConnectOptions();
//		if (!this.username.isEmpty())
			connOpt.setUserName("aux" + unixTime);
//		if (!this.password.isEmpty())
//			connOpt.setPassword(this.password.toCharArray());
		try {
			auxClient = new MqttClient("tcp://" + "localhost" + ":"
					+ 1883,  
					5 + "_pub_" + unixTime);
			auxClient.connect(connOpt);
		}catch (MqttSecurityException e) {
			// TODO Auto-generated catch block
			auxClient = null;
			e.printStackTrace();
		}catch (MqttException e) {
			// TODO Auto-generated catch block
			auxClient = null;
			e.printStackTrace();
		}
		return auxClient;
	}
	
}
