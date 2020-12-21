/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.entity;

/**
 *
 * @author May tinh Duy Toi
 */
public class Student {
    private int id;
    private String name;
    private String homeTown;
    private float point;

    public Student(String name, String homeTown ) {
         this.name=name;
         this.homeTown=homeTown;
         this.point=0;
    }

    public void setPoint(float point) {
        if(point>0 && point<10){
            this.point = point;
        }
        else{
            this.point=0;
        }
    }
    
    public void addPoint(float point){
        this.point+=point;
        System.out.println("Điểm sau khi cộng là:"+this.point);
    }
    public String diemBangChu(float point){
        if(point<4.0) return "Yếu";
        if(point<6) return "Trung bình";
        if(point<8) return "khá";
        if(point>8) return "Giỏi";
        return null;
    }
    public void studentPrinter(Student student){
        System.out.println("Họ tên :"+student.name);
        System.out.println("Xếp loại học lưc:"+diemBangChu(student.point));
    }

   
}
