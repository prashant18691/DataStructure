package com.test.prs.designpattern.decorator;

public class TestDecoratorPattern {
    public static void main(String[] args) {
        Car sportsCar = new CarDecorator(new SportsCar(new BasicCar()));
        sportsCar.assemble();
        System.out.println("************");
        Car sportsLuxuryCar = new CarDecorator(new LuxuryCar(new SportsCar(new BasicCar())));
        sportsLuxuryCar.assemble();
    }
}
