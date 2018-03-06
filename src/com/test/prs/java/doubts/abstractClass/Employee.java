package com.test.prs.java.doubts.abstractClass;

public class Employee extends AbstractEmployee {
    public Employee() {
    }

    public Employee(int empid, String firstName, String lastName, int salary, String dept) {
        super(empid, firstName, lastName, salary, dept);
    }

}
