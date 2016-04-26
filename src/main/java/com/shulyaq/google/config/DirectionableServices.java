package com.shulyaq.google.config;

import java.util.HashMap;

public class DirectionableServices {
    private HashMap<String, Object> services;

    public DirectionableServices() {
        services = new HashMap<String, Object>();
    }

    public Object getService(String name) {
        return services.get(name);
    }

    public void addService(String name, Object service) {
        services.put(name, service);
    }
}
