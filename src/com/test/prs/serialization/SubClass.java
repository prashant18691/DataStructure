package com.test.prs.serialization;

import java.io.*;

public class SubClass extends SuperClass implements Serializable,ObjectInputValidation {
    private static final long serialVersionUID = -1322322139926390329L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "SubClass{id="+getId()+",value="+getValue()+",name="+getName()+"}";
    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        setId(ois.readInt());
        setValue((String) ois.readObject());
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(getId());
        oos.writeObject(getValue());
    }
    @Override
    public void validateObject() throws InvalidObjectException {
        if(name==null || "".equals(name)) throw new InvalidObjectException("Corrupted");
        if(getId()<=0) throw new InvalidObjectException("ID can't be negative or zero");
    }
}
