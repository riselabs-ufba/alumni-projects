package usbListener;

import java.util.Enumeration;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/***
 * 
 * @author Edilton
 *
 */
public class JsonDecode {

	private String typeDevice = null;
	private String name = null;
	private String model = null;	
	
	/***
	 * 
	 */
	public JsonDecode() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTypeDevice(){
		return this.typeDevice;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getModel(){
		return this.model;
	}
	
	/***
	 * 
	 * @param message
	 */
	public void decodeMessagePropertyDevice(String message){
		
		JSONObject json = null;
		String typeDevice = "typeDevice";
		String name = "name";
		String model = "model";
		
		try {								
			json = new JSONObject(message);						
		    
			if (json != null){
				if (!json.isNull(typeDevice) && !json.isNull(name) && !json.isNull(model)){
					/*Informações básica do sensor/atuador.*/
					this.typeDevice = json.getString(typeDevice);
					this.name = json.getString(name);
					this.model = json.getString(model);		
				}
			}
		} catch (JSONException e) {			
			e.printStackTrace();
		} finally{
			if(json != null){
				json = null;
			}
		}
	}
	
	public String toString(){
		StringBuilder device = new StringBuilder();
		
		device.append("Type Device: " + this.typeDevice);
		device.append("Name: " + this.name);
		device.append("Model: " + this.model);		
		
		return device.toString();		
	}
}