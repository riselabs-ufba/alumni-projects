package com.she.core.driver.presence.impl;

import com.she.core.driver.presence.DriverMqtt;
import com.she.core.driver.presence.MqttListener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PresenceActivator implements BundleActivator {

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

