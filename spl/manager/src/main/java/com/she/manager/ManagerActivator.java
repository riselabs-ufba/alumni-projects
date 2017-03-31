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
		DriverMqtt driver = new DriverMqtt.DriverMqttBuilder().topicListener("manager").callback(callback).build("manager");
//    	
//    	driver = new DriverMqtt.DriverMqttBuilder().topicListener("Sensor").build("manager");
    	System.out.println("Driver builded");
    	
    }

    public void stop(BundleContext bundleContext) throws Exception {
        //When we stop, clean up the references.
//    	driver.disconnect();
    }
    
//	The method for correctly publish
//	public boolean publish(String messageString) {
//		MqttMessage msg = new MqttMessage();
//		String topic = "dev/" + username;
//		msg.setPayload(messageString.getBytes());
//		try {
//			listenerClient.publish(topic, msg);
//		} catch (MqttPersistenceException e) {
//			// TODO Auto-generated catch block
//			
//		} catch (MqttException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return true;
//	}

}

