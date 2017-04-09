package generator;

import java.util.Iterator;

import org.json.JSONObject;

public class Manager {
	String command = "/home/ramon/Downloads/apache/apache-karaf-4.0.8/bin/client ";
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	public void iterativeStatusSet(JSONObject json) throws Exception {		
		Iterator<?> keys = json.keys();

		while( keys.hasNext() ) {
		    String key = (String)keys.next();
		    setBundleStatus(json.getBoolean(key), key);

		}
	}
	private void setBundleStatus(boolean status, String bundleName) throws Exception {
		// TODO Auto-generated method stub
		Process p;
		if (status){
			Runtime.getRuntime().exec(command + "start " + bundleName).waitFor();
//			p.waitFor();
			System.out.println(command + "start " + bundleName);
		} else {
			Runtime.getRuntime().exec(command + "stop " + bundleName);
//			p.waitFor();
			System.out.println(command + "stop " + bundleName);
		}
	}
}
