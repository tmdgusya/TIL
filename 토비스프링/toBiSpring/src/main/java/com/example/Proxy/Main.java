package com.example.Proxy;

public class Main {

    public static void main(String[] args) {
        Service proxy = new Proxy(new IService());
        System.out.println(proxy.printSomething());
    }

}
