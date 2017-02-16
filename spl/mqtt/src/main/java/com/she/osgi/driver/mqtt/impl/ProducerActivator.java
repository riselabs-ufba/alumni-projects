package com.she.osgi.driver.mqtt.impl;

import com.she.osgi.driver.mqtt.RequestResponseApi;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

// mqtt

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class ProducerActivator implements BundleActivator {

    RequestResponseApi requestResponse = new RequestResponseService();
    ServiceRegistration registration;

    public void start(BundleContext bundleContext) throws Exception {
        //Register the service with the container.
        //Register the Interface, implementation and possible properties
        init();
        registration = bundleContext.registerService(RequestResponseApi.class.getName(), requestResponse, null);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        //When we stop, clean up the references.
        registration.unregister();
    }



    // <Ramon>
        public static String topicPrefix = "dev/";

        private String brokerUrl;
        private String brokerPort;
        private String serverId;
        private String username;
        private String password;
        private int collectTemperature;
        private int collectCurrent;
        private int publish;
        private MqttClient publisher;
    // </Ramon>

        public void init() {
          MqttConnectOptions connOpt = new MqttConnectOptions();
          connOpt.setUserName("random");

        System.out.println("Os set também");


          try {
            long unixTime = System.currentTimeMillis() / 1000L;

            System.out.println("Tentando conectar to the publisher");

            publisher = new MqttClient("tcp://" + "localhost" + ":"
                + 1883, "don" + "_pub" + unixTime);
            publisher.connect(connOpt);

            MqttMessage msg = new MqttMessage();
            String msgStr = "Hello caralho";
            msg.setPayload(msgStr.getBytes());

            publisher.publish("connected",msg);
            // getServicesAndBuildMsgs();
          } catch (MqttSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

        }
}
