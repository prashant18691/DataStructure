package com.test.prs.serialization;

import java.io.IOException;

public class TestSerializationSingleton {
    public static void main(String[] args) {
        SingletonClass s = SingletonClass.getInstance();
        String filename = "singleton.ser";

        try {
            SerializationDeserializationUtil.serialize(s,filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SingletonClass newSingleton = null;
        try {
            newSingleton = (SingletonClass)SerializationDeserializationUtil.deserialize(filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(s.hashCode()==newSingleton.hashCode());
    }
}
