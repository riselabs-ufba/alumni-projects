package br.ufba.she.model.mqtt;

import br.ufba.she.view.PrincipalFormShe;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.json.JSONArray;
import org.json.JSONObject;

//import com.she.core.driver.sensors.Sensor;
//import com.she.core.driver.sensors.TemperatureSensor;

public abstract class MqttListener implements MqttCallback {
	MqttClient client;

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

	public void setClient(MqttClient client) {
		// TODO Auto-generated method stub
		this.client = client;
	}
	
	public boolean publish(String messageString) {
		return publish(messageString,"serviceChat");
	}
//	The method for correctly publish
	public boolean publish(String messageString,String topic) {
//		This auxClient is a <workaround> to fix a <bug>!
		MqttClient auxClient;
//		System.out.println("Entrei");
		MqttMessage msg = new MqttMessage();
//		String topic = "serviceChat";
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
	
	private MqttClient auxBuilder() {
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		long unixTime = System.currentTimeMillis() / 10L;
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
