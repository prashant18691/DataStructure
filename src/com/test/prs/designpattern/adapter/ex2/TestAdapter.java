package com.test.prs.designpattern.adapter.ex2;

public class TestAdapter {
    public static void main(String[] args) {
        Adapter adapter = new AdapterImpl();
        Volt v3 = adapter.get3Volts();
        Volt v12 = adapter.get12Volts();
        Volt v120 = adapter.get120Volts();
        System.out.println(v3.getVolts());
        System.out.println(v12.getVolts());
        System.out.println(v120.getVolts());
    }
}
