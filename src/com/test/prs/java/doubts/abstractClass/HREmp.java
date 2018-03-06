package com.test.prs.java.doubts.abstractClass;

public class HREmp extends AbstractEmployee {
    public HREmp(int empid, String firstName, String lastName, String dept) {
        super(empid, firstName, lastName, dept);
    }

    @Override
    public int getEmpid() {
        return super.getEmpid();
    }

    @Override
    public void setEmpid(int empid) {
        super.setEmpid(empid);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String getDept() {
        return super.getDept();
    }

    @Override
    public void setDept(String dept) {
        super.setDept(dept);
    }
}
