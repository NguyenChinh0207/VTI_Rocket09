package com.entity;

import java.time.LocalDate;

public class Student_Comparing implements Comparable<Student_Comparing>  {
    private int id;
    private String name;
    private LocalDate ngaySinh;
    private int diem;

    public Student_Comparing() {
    }

    public Student_Comparing(int id, String name, LocalDate ngaySinh, int diem) {
        this.id = id;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.diem = diem;
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

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Student_Comparing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diem=" + diem +
                '}';
    }



    @Override
    public int compareTo(Student_Comparing student) {
        if(name == student.name){
            if(ngaySinh==student.ngaySinh){
                if (diem> student.diem) {
                    return 1;
                }
                if (diem< student.diem) {
                    return -1;
                }
            }
            else{
                if (ngaySinh.compareTo(student.ngaySinh) > 0) {
                    return 1;
                }
                if (ngaySinh.compareTo(student.ngaySinh) < 0) {
                    return -1;
                }

            }
        }
        else{
            if (name.compareTo(student.name) > 0) {
                return 1;
            }
            if (name.compareTo(student.name) < 0) {
                return -1;
            }
        }
        return 0;

    }
}
