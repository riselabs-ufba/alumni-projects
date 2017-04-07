package br.ufba.she.model.mqtt;

import br.ufba.she.utils.JsonDecode;
import br.ufba.she.view.device.GenericDevice;
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
import org.json.JSONArray;
import org.json.JSONObject;


public class ScreenMqttListener extends MqttListener{
	MqttClient client;
        GenericDevice device;

    public ScreenMqttListener(GenericDevice device) {
        this.device = device;
    }
        
        

	@Override
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
//		manager.iterativeStatusSet(new JSONObject(arg1.toString()));
//		publish(arg1.toString());
//		JSONObject json =  new JSONObject(arg1.toString());
                JsonDecode jsonDecode = new JsonDecode();
                
                String[] keys = jsonDecode.getKeys(arg1.toString());
                String[] values = jsonDecode.getValues(keys,arg1.toString());
                device.tableFormat(values,keys);
	}
	
	
}
