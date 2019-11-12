package com.test.prs.designpattern.adapter.ex1;

public class TestAdapterPattern {
    public static void main(String[] args) {
        Captain captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }
}
