package com.she.core.driver.luminosity.impl;

import com.she.core.driver.luminosity.DriverMqtt;
import com.she.core.driver.luminosity.MqttListener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ProducerActivator implements BundleActivator {

    DriverMqtt driver;
    MqttListener listener;

    public void start(BundleContext bundleContext) throws Exception {
  
    	driver = new DriverMqtt.DriverMqttBuilder().topicListener("dev/LuminositySensor").build("lumis");
    	
    }

    public void stop(BundleContext bundleContext) throws Exception {
    	driver.disconnect();
    }

}

