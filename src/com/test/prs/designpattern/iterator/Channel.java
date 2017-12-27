package com.test.prs.designpattern.iterator;

public class Channel {

    public Channel(double frquency, ChannelType type) {
        this.frquency = frquency;
        this.type = type;
    }

    private double frquency;
    private ChannelType type;

    public double getFrquency() {
        return frquency;
    }

    public void setFrquency(double frquency) {
        this.frquency = frquency;
    }

    public ChannelType getType() {
        return type;
    }

    public void setType(ChannelType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "frquency=" + frquency +
                ", type=" + type +
                '}';
    }
}
