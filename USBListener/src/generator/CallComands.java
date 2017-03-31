package generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.she.manager.DriverMqtt;
import com.she.manager.MqttListener;

public class CallComands {
	String command = "/home/ramon/Downloads/apache/apache-karaf-4.0.8/bin/client ";
	public static void main(String[] args) {
		System.out.println("Começou");
		CallComands call = new CallComands();
	}
	
	public CallComands() {

		System.out.println("Chamou");
		MqttListener callback = new ManagerMqttListener(); 
		DriverMqtt driver = new DriverMqtt.DriverMqttBuilder().callback(callback).build("manager");
		
	}

}
