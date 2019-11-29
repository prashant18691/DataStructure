package com.test.prs.java.doubts.lamda;

public class StaffPublic {

    public StaffPublic(String name, int age, String extra) {
        this.name = name;
        this.age = age;
        this.extra = extra;
    }

    private String name;
    private int age;
    private String extra;
    //...


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
