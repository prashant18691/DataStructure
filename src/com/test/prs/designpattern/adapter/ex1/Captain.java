package com.test.prs.designpattern.adapter.ex1;

public class Captain implements RowingBoat{
    private RowingBoat boat; // using composition

    public Captain(RowingBoat boat) {
        this.boat = boat;
    }
    @Override
    public void row(){
        boat.row();
    }
}
