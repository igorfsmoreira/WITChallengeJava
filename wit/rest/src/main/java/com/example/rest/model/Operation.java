package com.example.rest.model;

public class Operation {
    public static final String ADDITION = "addition";
    public static final String SUBTRACTION = "subtraction";
    public static final String MULTIPLICATION = "multiplication";
    public static final String DIVISION = "division";
    private final double mResult;

    public Operation(double result) {
        mResult = result;
    }

    public double getResult() {
        return mResult;
    }
}
