package com.example.Proxy;

public class IService implements Service{

    @Override
    public String printSomething() {
        return "Hello Java";
    }

}
