package com.test.prs.java.doubts.clone;

public class A implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A();
        System.out.println(a.hashCode());
        System.out.println(a.clone().hashCode());
    }
}
