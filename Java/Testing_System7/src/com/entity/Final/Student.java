package com.entity.Final;

public  class Student {
    private final int id;
    private String name;

    public Student(int id, String name) {
        this.id=1;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public final void study(){
        System.out.println("Đang học bài ...");
    }

}
