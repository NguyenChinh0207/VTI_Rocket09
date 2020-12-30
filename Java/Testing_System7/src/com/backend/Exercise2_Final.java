package com.backend;

import com.entity.Final.MyMath;
import com.entity.Final.PrimaryStudent;
import com.entity.Final.SecondaryStudent;
import com.entity.Final.Student;

import java.util.Scanner;

public class Exercise2_Final {
    public static Scanner scanner=new Scanner(System.in);
    public void Question1(){
        System.out.println("Nhap so:");
        float num=scanner.nextFloat();
        System.out.println("Tong:"+ MyMath.sum(num));
    }
    public void Question2(){

        Student student1 = new Student(1, "Chinh");
        System.out.println(student1.getId());
        Student student2 = new Student(2, "Lan");
        System.out.println(student2.getId());
        Student student3 = new Student(3, "Ngọc");
        System.out.println(student3.getId());
        Student student4 = new Student(4, "Minh Duy");
        System.out.println(student4.getId());

    }
    public void Question3(){
        Student student1=new PrimaryStudent(1,"chinh");
        System.out.println("PrimaryStudent:");
        student1.study();

        SecondaryStudent student2 = new SecondaryStudent(1,"Lan");
        System.out.println("SecondaryStudent:");
        student2.study();
    }
}
