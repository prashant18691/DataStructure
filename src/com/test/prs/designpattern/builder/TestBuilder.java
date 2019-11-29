package com.test.prs.designpattern.builder;

public class TestBuilder {
    public static void main(String[] args) {
        Computer computer = Computer.ComputerBuilder.create().
                setGraphics(10).setHdd(120).setRam(8).setSsd(50).build();
        System.out.println(computer);
    }
}
