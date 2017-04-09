package generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
//		System.out.println("Começou");
		CallComands call = new CallComands();
	}
	
	public CallComands() {
		List<String> lines = new ArrayList<String>();
	    String line = null;
//
//		System.out.println("Chamou");
//		MqttListener callback = new ManagerMqttListen public void  doIt() {
	    try {
	    	JSONObject json = new JSONObject("{\"temperature\":true,\"luminosity\":false,\"LCD\":true}");
	        File f1 = new File("/home/ramon/Estudos/2016_2/reuso_soft/spl/arduSPL/device/flags.h");
	        FileReader fr = new FileReader(f1);
	        BufferedReader br = new BufferedReader(fr);
	        while ((line = br.readLine()) != null) {
//	            if (line.contains("java"))
//	                line = line.replace("java", " ");
	        	int x = line.lastIndexOf("#define") + "#define".length() + 1;
	        	String feature = line.substring(x);
	        	 
	        	try {
	        		boolean status = json.getBoolean(feature);
					System.out.println(status);
					if (status) {
						line = "#define " + feature; 
//						line = new StringBuilder(line).insert(0,"//").toString();
					} else {
						line = "//#define " + feature;
					}
					
				} catch (Exception e) {
					// in case of a exception don't do anything
				}
	        	
//	        	line = new StringBuilder(line).insert(0,"//").toString();
	            lines.add(line);
	        }
	        System.out.println(lines);
	        fr.close();
	        br.close();
	
	        FileWriter fw = new FileWriter(f1);
	        BufferedWriter out = new BufferedWriter(fw);
	        for(String s : lines)
	             out.write(s + "\n");
	        out.flush();
	        out.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		 
//		DriverMqtt driver = new DriverMqtt.DriverMqttBuilder().callback(callback).build("manager");
//		
	}

}
