package com.example.calculatorforandroid;

public class Calculator {

    private double firstArgument;
    private double secondArgument;
    private double thirdArgument;

    private StringBuilder str = new StringBuilder();
    private int actionSelected;

    private State state;

    private enum State {
        FIRST_ARG_INPUT,
        SECOND_ARG_INPUT,
        RESULT_SHOW
    }

    public Calculator() {
        state = State.FIRST_ARG_INPUT;
    }

    public void onActionPressed(int actionId) {
        if (actionId == R.id.key_c && state == State.FIRST_ARG_INPUT && str.length() > 0) {
            state = State.RESULT_SHOW;
            str.setLength(0);
        }

        if (actionId == R.id.key_c && state == State.SECOND_ARG_INPUT && str.length() > 0) {
            state = State.RESULT_SHOW;
            str.setLength(0);
        }

        if (actionId == R.id.key_c && state == State.RESULT_SHOW && str.length() > 0) {
            state = State.RESULT_SHOW;
            str.setLength(0);
        }

        if (actionId == R.id.key_percent && state == State.FIRST_ARG_INPUT && str.length() > 0) {
            firstArgument = Double.parseDouble(str.toString());
            state = State.RESULT_SHOW;
            str.setLength(0);
            str.append(firstArgument / 100);
        }

        if (actionId == R.id.key_result && state == State.SECOND_ARG_INPUT && str.length() > 0) {
            secondArgument = Double.parseDouble(str.toString());
            state = State.RESULT_SHOW;
            str.setLength(0);
            switch (actionSelected) {
                case R.id.key_sum:
                    str.append(firstArgument + secondArgument);
                    break;
                case R.id.key_minus:
                    str.append(firstArgument - secondArgument);
                    break;
                case R.id.key_divide:
                    str.append(firstArgument / secondArgument);
                    break;
                case R.id.key_multiply:
                    str.append(firstArgument * secondArgument);
                    break;
            }

        } else if (str.length() > 0 && state == State.FIRST_ARG_INPUT) {
            firstArgument = Double.parseDouble(str.toString());
            state = State.SECOND_ARG_INPUT;
            str.setLength(0);
            switch (actionId) {
                case R.id.key_sum:
                    actionSelected = R.id.key_sum;
                    break;
                case R.id.key_minus:
                    actionSelected = R.id.key_minus;
                    break;
                case R.id.key_multiply:
                    actionSelected = R.id.key_multiply;
                    break;
                case R.id.key_divide:
                    actionSelected = R.id.key_divide;
                    break;
                case R.id.key_percent:
                    actionSelected = R.id.key_percent;
                    break;
            }
        }
    }

    public void onNumPressed(int numberId) {
        if (state == State.RESULT_SHOW) {
            state = State.FIRST_ARG_INPUT;
            str.setLength(0);
        }
        if (str.length() < 9) {
            switch (numberId) {
                case R.id.key_0:
                    str.append("0");
                    break;
                case R.id.key_1:
                    str.append("1");
                    break;
                case R.id.key_2:
                    str.append("2");
                    break;
                case R.id.key_3:
                    str.append("3");
                    break;
                case R.id.key_4:
                    str.append("4");
                    break;
                case R.id.key_5:
                    str.append("5");
                    break;
                case R.id.key_6:
                    str.append("6");
                    break;
                case R.id.key_7:
                    str.append("7");
                    break;
                case R.id.key_8:
                    str.append("8");
                    break;
                case R.id.key_9:
                    str.append("9");
                    break;
                case R.id.key_drop:
                    str.append(".");
                    break;
                case R.id.key_plus_minus:
                    str.replace(0, 0, "-");
            }

        }


    }

    public String getText() {
        return str.toString();
    }
}
