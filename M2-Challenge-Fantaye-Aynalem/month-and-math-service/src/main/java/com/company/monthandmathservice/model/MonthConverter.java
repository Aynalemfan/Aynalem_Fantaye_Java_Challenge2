package com.company.monthandmathservice.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class MonthConverter {
    @NotEmpty(message = "You must give a number.")
    private int number;
    @NotEmpty(message = "You must give a name.")
    private String name;


    public MonthConverter(int number,String name) {
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
        if (!(o instanceof MonthConverter)) return false;
        MonthConverter month = (MonthConverter) o;
        return getNumber() == month.getNumber() && getName().equals(month.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(),getName());
    }

    @Override
    public String toString() {
        return "Month{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    public int nextInt(int i) {
        return 0;
    }
}

