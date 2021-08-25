package com.example.calculatorforandroid;

public class Calculator {

    private int firstArgument;
    private int secondArgument;

    StringBuilder str = new StringBuilder();

    private State state;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public Calculator() {
        state = State.firstArgInput;
    }

    public void onActionPressed(int actionID){

    }

    public void onNumPressed(int numberID){

    }

}
