package com.entity.Generic;

import java.util.Arrays;

public class Employee<T>{
    private int id;
    private String name;
    private T[] salaries;

    public Employee(String name, T[] salaries) {
        this.name = name;
        this.salaries = salaries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T[] getSalaries() {
        return salaries;
    }

    public void setSalaries(T[] salaries) {
        this.salaries = salaries;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salaries=" + Arrays.toString(salaries) +
                '}';
    }
}
