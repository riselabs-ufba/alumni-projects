/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.she.model.mqtt;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Edilton
 */
public class MqttClientUtil implements MqttCallback  {
    
    private static String mqttHost = null;
    private String buildName = null; 
    private static final String LOCALHOST = "localhost";
    private static final String PORT = "1883";
    private static final String PROTOCOL = "tcp://";
    private String messageForum = null;
    
    
    public MqttClientUtil(){
        this(LOCALHOST);
    }
    
    public MqttClientUtil(String mqttHost){
        MqttClientUtil.mqttHost = mqttHost;        
    }
    
    public MqttClientUtil(String mqttHost, String messageForum){
        MqttClientUtil.mqttHost = mqttHost;
        this.messageForum = messageForum;
    }
    
    private void conect(){
        
    }        

    @Override
    public void connectionLost(Throwable thrwbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void messageArrived(String string, MqttMessage mqttMessage){                                
                                  
        this.publish(mqttMessage);       
    }
    
    /**
     * Método utilizado para fazer publicações em determinado forum MQTT.
     * @param messageString mensagem para ser publicada.
     * @return retorna true se a mensagem foi publicada, caso contrário retorna false.
     */
    public boolean publish(String messageString) {        
        MqttMessage mqttMessage = new MqttMessage();  
        boolean publishMessage = false;
       
        if((messageString != null) && !messageString.isEmpty()){
            mqttMessage.setPayload(messageString.getBytes());
            publishMessage = this.publish(mqttMessage);
        }
                        
        return publishMessage;                 
    }
    
    /**
     * Método utilizado para fazer publicações em determinado forum MQTT.
     * @param mqttMessage mensagem para ser publicada.
     * @return retorna true se a mensagem foi publicada, caso contrário retorna false.
     */
    public boolean publish(MqttMessage mqttMessage) {
        MqttClient auxClient;
                             
        try {            
            auxClient = connectBuilder();
            auxClient.publish(this.messageForum, mqttMessage);          
        } catch (MqttPersistenceException ex) {            
            Logger.getLogger(MqttClientUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MqttException ex) {
            Logger.getLogger(MqttClientUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    /***
     * Método utilizado para fazer a conexão com o servidor MQTT.
     * @return retorna um MqttClient com a conexão.
     */
    private MqttClient connectBuilder() {
        long unixTime = System.currentTimeMillis() / 1000L;
        MqttClient auxClient;
        MqttConnectOptions connOpt = new MqttConnectOptions();
    
        connOpt.setUserName("aux" + unixTime);

        try {
            // ver esse trecho com Ramon.
            auxClient = new MqttClient(MqttClientUtil.PROTOCOL + MqttClientUtil.LOCALHOST + ":"
                            + MqttClientUtil.PORT,  
                            5 + "_pub_" + unixTime);
            auxClient.connect(connOpt);
            auxClient.setCallback(this);
            
        }catch (MqttSecurityException ex) {                
            auxClient = null;       
            connOpt = null;
            Logger.getLogger(MqttClientUtil.class.getName()).log(Level.SEVERE, null, ex);
        }catch (MqttException ex) {            
            auxClient = null;  
            connOpt = null;
            Logger.getLogger(MqttClientUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return auxClient;
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getMessageForum(String forum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /***
     * Pega dados de messageForum específico.     
     * @return Retorna a string 
     */
    public String getMessageForum(){
        return this.messageForum;
    }
}   
