package com.test.prs.serialization;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Data implements Serializable {

    private static final long serialVersionUID = 2087368867376448459L;

    private String data;

    public Data(String d){
        this.data=d;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "Data{data="+data+"}";
    }

    private static class DataProxy implements Serializable {
        private String dataProxy;
        private static final String PREFIX = "ABC";
        private static final String SUFFIX = "DEFG";
        private static final long serialVersionUID = 8333905273185436744L;

        public DataProxy(Data data) {
            this.dataProxy=PREFIX+data.getData()+SUFFIX;
        }

        private Object readResolve(){
            if(dataProxy.startsWith(PREFIX) && dataProxy.endsWith(SUFFIX))
                return new Data(dataProxy.substring(3,dataProxy.length()-4));

            return new InvalidObjectException("Corrupted");
        }
    }

    private void readObject(ObjectInputStream ois) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy is not used, something fishy");
    }

    private Object writeReplace(){
        return new DataProxy(this);
    }

}
