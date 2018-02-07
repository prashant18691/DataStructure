package com.test.prs.serialization;

import java.io.IOException;

public class TestInheritanceSerialization {
    public static void main(String[] args) {
        String fileName = "subclass.ser";

        SubClass subClass = new SubClass();
        subClass.setId(10);
        subClass.setValue("Data");
        subClass.setName("Pankaj");

        try {
            SerializationDeserializationUtil.serialize(subClass,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SubClass newSubClass = null;

        try {
            newSubClass = (SubClass) SerializationDeserializationUtil.deserialize(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(newSubClass);
    }
}
