/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.she.model.mqtt;

/**
 *
 * @author Edilton
 */
public class GenericDao {
    private final MqttClientUtil mqttClent;

    public GenericDao() {
        this.mqttClent = new MqttClientUtil();
    }
      
    public String getDados(String forum){
        return this.mqttClent.getMessageForum(forum);
    }              
}
