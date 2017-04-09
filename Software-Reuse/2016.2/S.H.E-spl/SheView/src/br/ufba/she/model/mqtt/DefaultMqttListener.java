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
import org.json.JSONObject;

public class DefaultMqttListener extends MqttListener {
	MqttClient client;

	@Override
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		// TODO Auto-generated method stub
                
                System.out.println("Chegou!!");
		JSONObject json = new JSONObject(arg1.toString());
//		int value =  json.getInt("value");
//		sensor.setValue(String.valueOf(value));
//                System.out.println("Pegando ");
//                JSONArray arr = new JSONArray(json.getJSONArray("devices"));
                List<String> list = new ArrayList<String>();
                System.out.println("Listando!!");
                for(int i = 0; i < json.getJSONArray("devices").length(); i++){
                    list.add(json.getJSONArray("devices").get(i).toString());
                }
                
                String [] message = list.toArray(new String[list.size()]);
                PrincipalFormShe.setMessage(message);
//                System.out.println(message[0]);

//		sensor.setValue(json);                
//		publish(sensor.getValue());
                
                //Allow screen construction
                PrincipalFormShe.setStart(true);
                System.out.println("Setou!!");
	}
	

}
