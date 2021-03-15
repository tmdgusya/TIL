package com.example.Proxy;

public class Proxy implements Service {

    Service service;

    public Proxy(Service service) {
        this.service = service;
    }

    @Override
    public String printSomething() {
        System.out.println("Service Loading...");
        return service.printSomething();
    }

}
