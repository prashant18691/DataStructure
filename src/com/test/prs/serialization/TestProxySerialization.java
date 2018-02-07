package com.test.prs.serialization;

import java.io.IOException;

public class TestProxySerialization {
    public static void main(String[] args) {
        String fileName = "data.ser";
        Data data = new Data("Pankaj");
        try {
            SerializationDeserializationUtil.serialize(data,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Data newData = null;
        try {
            newData = (Data)SerializationDeserializationUtil.deserialize(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(newData);
        System.out.println(data.hashCode()+" "+newData.hashCode());
    }
}
