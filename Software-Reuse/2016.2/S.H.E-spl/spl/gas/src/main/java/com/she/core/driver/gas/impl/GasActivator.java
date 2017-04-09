package com.she.core.driver.gas.impl;

import com.she.core.driver.gas.DriverMqtt;
import com.she.core.driver.gas.MqttListener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class GasActivator implements BundleActivator {

    DriverMqtt driver;
    MqttListener listener;

    public void start(BundleContext bundleContext) throws Exception {
  
    	driver = new DriverMqtt.DriverMqttBuilder().topicListener("dev/LuminositySensor").build("LuminositySensor");
    	
    }

    public void stop(BundleContext bundleContext) throws Exception {
    	try {
    		driver.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }

}

