package com.she.manager;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ManagerActivator implements BundleActivator {
	
	private MqttClient listenerClient;
	MqttListener callback;
	DriverMqtt driver;
	String brokerUrl = "localhost";
	String brokerPort = "1883";
	String username = "device";
	
    public void start(BundleContext bundleContext) throws Exception {
    	System.out.println("Started");
    	
    	MqttListener callback = new ManagerMqttListener(); 
		driver = new DriverMqtt.DriverMqttBuilder().topicListener("connections").callback(callback).build("manager");
//    	
//    	driver = new DriverMqtt.DriverMqttBuilder().topicListener("Sensor").build("manager");
    	System.out.println("Driver builded");
    	
    }

    public void stop(BundleContext bundleContext) throws Exception {
        //When we stop, clean up the references.
    	driver.disconnect();
    }

}

