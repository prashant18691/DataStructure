package com.test.prs.java.doubts.abstractClass;

public abstract class AbstractEmployee {
    public AbstractEmployee() {
    }

    @Override
    public String toString() {
        return "AbstractEmployee{" +
                "empid=" + empid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }

    public AbstractEmployee(int empid, String firstName, String lastName, int salary, String dept) {
        this.empid = empid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dept = dept;
    }

    public AbstractEmployee(int empid, String firstName, String lastName, String dept) {
        this.empid = empid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
    }

    public AbstractEmployee(int empid, int salary, String dept) {
        this.empid = empid;
        this.salary = salary;
        this.dept = dept;
    }

    private int empid;
    private String firstName;
    private String lastName;
    private int salary;
    private String dept;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
