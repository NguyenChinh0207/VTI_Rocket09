package com.entity;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private static int count = 0;

    public Student(String name) {
        this.id = ++count;
        this.name = name;

    }

    public  String getID2(){
        return "MSV:"+id;
    }
    public String getName() {
        return name;
    }

    /**
   * @deprecated replaced by {@link #getID2()}
   */
    @Deprecated
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
