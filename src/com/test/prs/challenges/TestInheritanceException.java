package com.test.prs.challenges;

import java.io.IOException;

public class TestInheritanceException {
    public static void main(String[] args) {

    }
}

class A1{
    protected void d() throws Exception{
    }
   /*protected void d(){
   }*/
    public Exception throwEx(){
        return new RuntimeException();
    }

    public Exception throwEx(int a){
        return new RuntimeException();
    }
}

class B1 extends A1{
    @Override
    protected void d() throws IOException {
    }
    /*@Override
    protected void d() throws RuntimeException{

    }*/
    @Override
    public Exception throwEx(){
        return new Exception();
    }
}
