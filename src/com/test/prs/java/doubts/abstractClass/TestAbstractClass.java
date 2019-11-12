package com.test.prs.java.doubts.abstractClass;

import java.util.ArrayList;
import java.util.List;

public class TestAbstractClass {//Decorater pattern
    public static void main(String[] args) {
        List<Employee> list = getDummyData();
            for (Employee e : list){
                System.out.println(e);
               /* HREmp hr =new HREmp(e);
                System.out.println(new HREmp(e));*/
                System.out.println(new PayrollEmp(e));
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            }
        }

    private static List<Employee>  getDummyData() {
        List<Employee> list = new ArrayList<>();
      /*  Employee e1 = new Employee(1,"Hansal","Mehta",1000,"HR");
        Employee e2 = new Employee(2,"Radhika","Sharma",3000,"IT");
        Employee e3 = new Employee(3,"Sarika","Singh",30200,"Payroll");
        Employee e4 = new Employee(4,"Mrinmoy","Roy",34000,"IT");
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);*/
        return list;
    }

}

