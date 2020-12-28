package com.entity;

public class Department {
    private int         id;
    private String      departmentName;

    public Department() {
        System.out.println("Nhap id:");
        id=scannerUtils.inputInt("Please input a number as int, please input again.");
        System.out.println("Nhap name:");
        departmentName=scannerUtils.inputString("Please input a string, please input again.");
    }

    public Department(int id,String departmentName){
        this.id     =   id;
        this.departmentName     =    departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
