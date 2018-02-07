package com.test.prs.serialization;

import java.io.Serializable;

public class SingletonClass implements Serializable {
    private SingletonClass(){
    }
    private static final long serialVersionUID = -1322322339926390329L;
    private static class SingletonClassHelper{
        private static final SingletonClass INSTANCE = new SingletonClass();
    }

    public static SingletonClass getInstance(){
        return SingletonClassHelper.INSTANCE;
    }

    private Object readResolve(){
        return getInstance();
    }
}
