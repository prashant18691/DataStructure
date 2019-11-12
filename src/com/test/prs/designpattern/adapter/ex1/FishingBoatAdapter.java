package com.test.prs.designpattern.adapter.ex1;

public class FishingBoatAdapter implements RowingBoat {
    private FishingBoat boat;

    public FishingBoatAdapter() {
        this.boat = new FishingBoat();
    }

    @Override
    public void row() {
        boat.sail();
    }
}
