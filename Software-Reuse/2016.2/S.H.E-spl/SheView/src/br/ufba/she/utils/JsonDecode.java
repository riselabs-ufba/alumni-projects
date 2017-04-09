/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.she.utils;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Edilton
 */
public class JsonDecode {

    private String typeDevice = null;
    private String name = null;
    private String model = null;
    private static final String TYPE_DEVICE = "typeDevice";
    private static final String NAME = "name";
    private static final String MODEL = "model"; 

    /***
     * 
     */
    public JsonDecode() {
        
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
     * Pega as informações de propriedade do device.
     * @param message recebe uma string no formato JSON.
     */
    public void decodePropertyDevice(String message){
        JSONObject json = null;       

        try {								
            json = new JSONObject(message);						
            this.decodePropertyDevice(json);                   
        } catch (JSONException ex) {			
                Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(json != null){
                json = null;
            }
        }
    }
    
    /***
     * Pega as informações de propriedade do device.
     * @param json Recebe um objeto JSONObject com os dados do device.
     */
    public void decodePropertyDevice(JSONObject json){				
        try {																		    
            if (json != null){
                if (!json.isNull(TYPE_DEVICE) && !json.isNull(NAME) && !json.isNull(MODEL)){
                    /*Informações básica do sensor/atuador.*/
                    this.typeDevice = json.getString(TYPE_DEVICE);
                    this.name = json.getString(NAME);
                    this.model = json.getString(MODEL);		
                }
            }else{
                throw new Exception("JSONObject is null.");
            }
        } catch (JSONException ex) {						
            Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /***
     * Pega as keys do JSONObject que representa os dados lidos do device, esse método não retorna keys de propriedades do device.
     * @param message recebe uma string no formato JSON.    
     * @return retorna uma array de String com os nomes de todas as keys do JSONObject que indicam litura de dados do device.
     */
    public String[] getKeys(String message){       
        String[] names = null;
        JSONObject jsonObject = null;
        
        try{        
            if (message != null){
                jsonObject = new JSONObject(message);                
                names = this.getKeys(jsonObject);
            } else{
                throw new Exception("String is null");
            }
        } catch (JSONException ex) {
            Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(jsonObject != null){
                jsonObject = null;
            }
        }
                
        return names;
    }
    
    /***
     * Pega as keys do JSONObject que representa a chave para os dados lidos do device, esse método não retorna keys de propriedades do device.
     * @param jsonObject Recebe um objeto JSONObject com os dados do device.
     * @return retorna uma array de String com as keys de JSONObject que indicam litura de dados do device.
     */
    public String[] getKeys(JSONObject jsonObject){
        JSONArray jsonNames = null;
        String[] names = null;
        int a = 0;
        
        try{        
            if (jsonObject != null){
                jsonNames = jsonObject.names();
                // O -3 indica que o array de nome não terá as propriedades do dispositivo.
                names = new String[jsonNames.length()-3];

                for(int i =0; i <jsonNames.length(); i++){
                    // Só adiciona na array valores lidos Device e as properties são descatadas.
                    if(!jsonNames.getString(i).equals(TYPE_DEVICE) &&
                       !jsonNames.getString(i).equals(NAME) &&   
                       !jsonNames.getString(i).equals(MODEL)){
                        names[a] = jsonNames.getString(i);
                        a++;
                    }
                }
            } else{
                throw new Exception("JSONObject is null");
            }
        } catch (JSONException ex) {
            Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return names;
    }
      
    /***
     * Pega os valores lidos do device.
     * @param keys Array de cheves que indentifica cada valor lido pelo device.
     * @param message Mensagem recebi do device pelo servidor MQTT.
     * @return retorna uma array de String com os valos lidos do device.
     */
    public String[] getValues(String[] keys, String message){
        String[] values = null;
        JSONObject jsonObject = null;
        
        try{        
            if ((message != null && keys != null) && (keys.length>0)){
                jsonObject = new JSONObject(message);                
                values = new String[keys.length];
                
                for(int i = 0; i < keys.length; i++){
                    values[i] = jsonObject.getString(keys[i]);
                }
                
            } else{
                throw new Exception("No value!");
            }
        } catch (JSONException ex) {
            Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JsonDecode.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(jsonObject != null){
                jsonObject = null;
            }
        }               
        
        return values;
    }            

    /***
     * 
     * @return 
     */    
    @Override
    public String toString(){
        StringBuilder device = new StringBuilder();

        device.append("Type Device: ").append(this.typeDevice);
        device.append("Name: ").append(this.name);
        device.append("Model: ").append(this.model);		

        return device.toString();		
    }
}
