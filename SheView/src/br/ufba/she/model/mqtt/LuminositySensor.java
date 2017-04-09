package br.ufba.she.model.mqtt;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class LuminositySensor extends Sensor {

	public LuminositySensor(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transformation(JSONObject value) {
		// TODO Auto-generated method stub
//		Convert value to lumis
		
            float lumis = 0; 
            try {
                lumis = Float.valueOf(value.getInt("value"));
                lumis = (float) ( lumis*(5.0/1024.0));
		lumis = (float) (( ( 2500.0 / lumis ) - 400.0)/2.0);
            } catch (JSONException ex) {
                Logger.getLogger(LuminositySensor.class.getName()).log(Level.SEVERE, null, ex);
            }
		
				
            return String.valueOf(lumis);
	}

}
