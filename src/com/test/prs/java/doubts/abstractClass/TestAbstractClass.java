package com.test.prs.java.doubts.abstractClass;

import java.util.ArrayList;
import java.util.List;

public class TestAbstractClass {
    public static void main(String[] args) {
        List<AbstractEmployee> list = getDummyData();
            for (AbstractEmployee e : list){
                System.out.println(e);
            }
        }

    private static List<AbstractEmployee>  getDummyData() {
        List<AbstractEmployee> list = new ArrayList<>();
        AbstractEmployee e1 = new HREmp(1,"Hansal","Mehta","HR");
        AbstractEmployee e2 = new Employee(2,"Radhika","Sharma",3000,"IT");
        AbstractEmployee e3 = new PayrollEmp(3,30200,"Payroll");
        AbstractEmployee e4 = new Employee(4,"Mrinmoy","Roy",34000,"IT");
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        return list;
    }

}

