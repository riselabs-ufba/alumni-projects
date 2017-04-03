package com.she.core.driver.temperature.impl;

import com.she.core.driver.temperature.RequestResponseApi;


public class RequestResponseService implements RequestResponseApi {

    //Simple return method, this method will be called as an OSGi service.
    public String getResponse(String request) {
        return ("You called the service with " + request);
    }
}
