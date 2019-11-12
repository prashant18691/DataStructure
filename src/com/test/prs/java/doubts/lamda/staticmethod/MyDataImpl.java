package com.test.prs.java.doubts.lamda.staticmethod;

public class MyDataImpl implements MyData {
    public boolean isNull(String s){
        System.out.println("impl is null");
        return s==null?true:false;
    }

    public static void main(String[] args) {
        MyDataImpl impl = new MyDataImpl();
        System.out.println(impl.isNull(""));
        impl.print("");
    }
}
