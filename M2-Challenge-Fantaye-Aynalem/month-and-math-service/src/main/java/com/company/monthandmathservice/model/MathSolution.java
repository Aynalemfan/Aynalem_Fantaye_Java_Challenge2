package com.company.monthandmathservice.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class MathSolution {
    @NotEmpty(message = "You must supply two numbers")
    private int operand1;
    @NotEmpty(message = "You must supply two numbers")
    @Min(1)
    private int operand2;
    private int answer;
    private String operation;
    public MathSolution() {
    }

    public MathSolution(int operand1,int operand2,int answer,String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.answer = answer;
        this.operation = operation;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathSolution)) return false;
        MathSolution that = (MathSolution) o;
        return getOperand1() == that.getOperand1() && getOperand2() == that.getOperand2() && getAnswer() == that.getAnswer() && Objects.equals(getOperation(),that.getOperation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperand1(),getOperand2(),getAnswer(),getOperation());
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", answer=" + answer +
                ", operation='" + operation + '\'' +
                '}';
    }

}

