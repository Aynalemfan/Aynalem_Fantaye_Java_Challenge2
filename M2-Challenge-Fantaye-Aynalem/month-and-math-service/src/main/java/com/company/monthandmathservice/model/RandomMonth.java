package com.company.monthandmathservice.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class RandomMonth {
    @NotEmpty(message = "You must give a number.")
    private int number;
    @NotEmpty(message = "You must give a name.")
    private String name;

    public RandomMonth() {}

    public RandomMonth(int number,String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RandomMonth)) return false;
        RandomMonth that = (RandomMonth) o;
        return getNumber() == that.getNumber() && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(),getName());
    }

    @Override
    public String toString() {
        return "RandomMonth{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}

