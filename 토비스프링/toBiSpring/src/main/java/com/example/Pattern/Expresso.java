package com.example.Pattern;

public class Expresso extends Beverage {

    public Expresso() {
        description = "에스프레소";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
