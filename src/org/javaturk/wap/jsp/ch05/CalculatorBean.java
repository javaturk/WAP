package org.javaturk.wap.jsp.ch05;

public class CalculatorBean {

    private double firstArgument;
    private double secondArgument;
    private String operation;
    private double result;

    public CalculatorBean() {
    }

    public double getFirstArgument() {
        return firstArgument;
    }

    public void setFirstArgument(double firstArgument) {
        this.firstArgument = firstArgument;
    }

    public double getSecondArgument() {
        return secondArgument;
    }

    public void setSecondArgument(double secondArgument) {
        this.secondArgument = secondArgument;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        if (operation.equals("+"))  result = firstArgument + secondArgument;
        else if (operation.equals("-"))  result = firstArgument - secondArgument;
        else if (operation.equals("*"))  result = firstArgument * secondArgument;
        else if (operation.equals("/"))  result = firstArgument / secondArgument;
        return result;
    }
}
