package com.test.prs.java.doubts.functionalInterfacelambda;

public class TestFunctionalMethod {
    public static void main(String[] args) {
        StateOwner stateOwner = new StateOwner();
        //Java7
        stateOwner.addStateListener(new StateChangeListener() {
            @Override
            public void onStateChange(State oldState, State newState) {

            }
        });
        //Java8
        stateOwner.addStateListener(((oldState, newState) -> {
            if (oldState.getId()!=newState.getId())
                System.out.printf("state changed");
            else
                System.out.printf("state unchanged");
        }));
    }
}
