package com.test.prs.designpattern.adapter.ex2;

public class Socket {
    public Volt getVolts(){
        return new Volt(120);
    }
}
