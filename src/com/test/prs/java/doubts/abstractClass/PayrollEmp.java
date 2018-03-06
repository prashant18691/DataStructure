package com.test.prs.java.doubts.abstractClass;

public class PayrollEmp extends AbstractEmployee {

    public PayrollEmp(int empid, int salary, String dept) {
        super(empid, salary, dept);
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
    public int getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
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
