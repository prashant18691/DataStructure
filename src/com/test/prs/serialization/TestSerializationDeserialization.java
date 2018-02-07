package com.test.prs.serialization;

import java.io.IOException;

public class TestSerializationDeserialization {
    public static void main(String[] args) {
        String fileName="employee.ser";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);
        try {
            SerializationDeserializationUtil.serialize(emp,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Employee newEmp = null;
        try {
            newEmp = (Employee) SerializationDeserializationUtil.deserialize(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(emp);
        System.out.println(newEmp);
    }

}
