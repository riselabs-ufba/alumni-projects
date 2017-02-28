package com.she.osgi.driver.mqtt.impl;

import com.she.osgi.driver.mqtt.MqttListener;
import com.she.osgi.driver.mqtt.RequestResponseApi;
import com.she.osgi.driver.mqtt.DriverMqtt;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProducerActivator implements BundleActivator {

    RequestResponseApi requestResponse = new RequestResponseService();
    ServiceRegistration registration;
    DriverMqtt driver;
    MqttListener listener;

    public void start(BundleContext bundleContext) throws Exception {
        //Register the service with the container.
        //Register the Interface, implementation and possible properties
//        init();
    	driver = new DriverMqtt.DriverMqttBuilder().password("password").build("device01");
    	
        registration = bundleContext.registerService(RequestResponseApi.class.getName(), requestResponse, null);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        //When we stop, clean up the references.
        registration.unregister();
    }

}

