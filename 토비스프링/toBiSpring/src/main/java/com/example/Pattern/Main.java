package com.example.Pattern;

public class Main {

    public static void main(String[] args) {
        Beverage bland = new HouseBland();
        bland = new Mocha(bland);
        bland = new Mocha(bland);
        System.out.println(bland.getDescription() + " & "  + bland.cost());
    }
}
