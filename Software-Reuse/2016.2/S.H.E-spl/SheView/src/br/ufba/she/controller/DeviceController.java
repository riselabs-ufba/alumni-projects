/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.she.controller;

import br.ufba.model.dao.DeviceDao;

/**
 *
 * @author Edilton
 */
public class DeviceController {
    private DeviceDao deviceDao = null;
    
    public DeviceController(){
        this.deviceDao = new DeviceDao();
    }
}
ç