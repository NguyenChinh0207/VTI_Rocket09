package com.entity.Static;

public class Student {
    private int id;
    private String name;
    private static String college;
    private static int moneyGroup;
    public static int count=0;

    public Student() {
        count++;
    }

    public static int getMoneyGroup() {
        return moneyGroup;
    }

    public static void setMoneyGroup(int moneyGroup) {
        Student.moneyGroup = moneyGroup;
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

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.college="Đại học bach khoa";
        moneyGroup+=100;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name +", college='" + college + ", moneyGroup='" + moneyGroup +'\'' +
                '}';
    }
}
