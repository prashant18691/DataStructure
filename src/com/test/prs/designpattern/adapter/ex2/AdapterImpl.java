package com.test.prs.designpattern.adapter.ex2;

public class AdapterImpl extends Socket implements Adapter {

    //or use composition
    //private Socket socket;
    /*

    public AdapterImpl(Socket s)[
        this.socket=s;
    }

     */
    @Override
    public Volt get120Volts() {
        return getVolts();
    }

    @Override
    public Volt get12Volts() {
        return convertVolt(10);
    }

    @Override
    public Volt get3Volts() {
        return convertVolt(40);
    }

    private Volt convertVolt(int i) {
        Volt volt = getVolts();
        return new Volt(volt.getVolts()/i);
    }
}
