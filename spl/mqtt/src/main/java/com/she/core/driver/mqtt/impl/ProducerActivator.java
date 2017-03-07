package com.she.core.driver.mqtt.impl;

import com.she.core.driver.mqtt.DriverMqtt;
import com.she.core.driver.mqtt.MqttListener;
import com.she.core.driver.mqtt.RequestResponseApi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProducerActivator implements BundleActivator {

//    RequestResponseApi requestResponse = new RequestResponseService();
    ServiceRegistration registration;
    ServiceRegistration serviceDriverRegistration;
    DriverMqtt driver;
    MqttListener listener;

    public void start(BundleContext bundleContext) throws Exception {
  
    	driver = new DriverMqtt.DriverMqttBuilder().topicListener("dev/sensor").build("device01");
    	
//      registration = bundleContext.registerService(RequestResponseApi.class.getName(), requestResponse, null);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        //When we stop, clean up the references.
//        registration.unregister();
    }

}

