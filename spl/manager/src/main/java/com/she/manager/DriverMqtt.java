package com.she.manager;

import org.eclipse.paho.client.mqttv3.MqttClient;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class DriverMqtt {
	// <Ramon>
	public static String topicPrefix = "dev/";

	private String brokerUrl;
	private String brokerPort;
	private String serverId;
	private String username;
	private String password;
	private String topicListener;
	private int publish;
	private MqttClient client;
	private MqttListener callback;
	

	// Manager	
//	private MqttClient manager;
	
	public DriverMqtt(String brokerUrl, String brokerPort, String serverId,
			String username, String password, String topicListener) {
		super();
		this.brokerUrl = brokerUrl;
		this.brokerPort = brokerPort;
		this.serverId = serverId;
		this.username = username;
		this.password = password;
		this.topicListener = topicListener;
		
		callback = new MqttListener();
		MqttConnectOptions connOpt = new MqttConnectOptions();
		if (!this.username.isEmpty())
			connOpt.setUserName(this.username);
		if (!this.password.isEmpty())
			connOpt.setPassword(this.password.toCharArray());
		try {
			long unixTime = System.currentTimeMillis() / 1000L;
			client = new MqttClient("tcp://" + this.brokerUrl + ":"
					+ this.brokerPort,  
					this.serverId + "_pub" + unixTime);
			client.connect(connOpt);
			announce();
			
			// Callback test
			 client.setCallback(callback);
			 System.out.println("Callback set");
			 client.subscribe(topicListener);
			 System.out.println("Client Subscribed");
			 callback.setClient(client);
			 System.out.println("Client is set");
//			 publish("Hello i'm the manager!");
			
		}catch (MqttSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void announce() throws MqttException {
		// After a successful connection: announce
		MqttMessage msg = new MqttMessage();
		String topic = "connections";
		msg.setPayload(username.getBytes());
		client.publish(topic, msg);
		
	}
	
//	The method for correctly publish
	public boolean publish(String messageString) {
		MqttMessage msg = new MqttMessage();
		String topic = topicPrefix + username;
		msg.setPayload(messageString.getBytes());
		try {
			client.publish(topic, msg);
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
//	subscribe
	public boolean subscribe() {
		try {
			client.subscribe(topicPrefix + username);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	public static String getTopicPrefix() {
		return topicPrefix;
	}



	public static void setTopicPrefix(String topicPrefix) {
		DriverMqtt.topicPrefix = topicPrefix;
	}


	public String getBrokerUrl() {
		return brokerUrl;
	}



	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}



	public String getBrokerPort() {
		return brokerPort;
	}



	public void setBrokerPort(String brokerPort) {
		this.brokerPort = brokerPort;
	}



	public String getServerId() {
		return serverId;
	}



	public void setServerId(String serverId) {
		this.serverId = serverId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getPublish() {
		return publish;
	}



	public void setPublish(int publish) {
		this.publish = publish;
	}



	public MqttClient getPublisher() {
		return client;
	}



	public void setPublisher(MqttClient publisher) {
		this.client = publisher;
	}
	
	public void disconnect() {
		try {
			System.out.println("Disconnecting " + username);
			client.disconnect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	Builder pattern
	public static class DriverMqttBuilder {
		private String brokerUrl = "localhost";
		private String brokerPort = "1883";
		private String serverId = "1";
		private String username = "";
		private String password = "";
		private MqttClient publisher;
		private MqttListener listener;
		private String topicListener = topicPrefix + username;
		
		public DriverMqtt build(String _name) {
			this.username = _name;
		    return new DriverMqtt(brokerUrl, brokerPort, serverId, username, password,topicListener);
		}

	    public DriverMqttBuilder host(String host)
	    {
	        this.brokerUrl = host;
	        return this;
	    }

	    public DriverMqttBuilder password(String password)
	    {
	        this.password = password;
	        return this;
	    }
	    public DriverMqttBuilder topicListener(String topicListener)
	    {
	        this.topicListener = topicListener;
	        return this;
	    }
	}

	
}


