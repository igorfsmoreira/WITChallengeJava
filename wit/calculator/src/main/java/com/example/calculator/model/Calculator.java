package com.example.calculator.model;

public class Calculator {
    public static final String ADDITION = "addition";
    public static final String SUBTRACTION = "subtraction";
    public static final String MULTIPLICATION = "multiplication";
    public static final String DIVISION = "division";

    public static double getResult(double operand1, double operand2, String operation) {
        switch (operation) {
            case ADDITION:
                return operand1 + operand2;
            case SUBTRACTION:
                return operand1 - operand2;
            case MULTIPLICATION:
                return operand1 * operand2;
            case DIVISION:
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}