package com.backend;

import com.entity.Static.MyMath;
import com.entity.Static.PrimaryStudent;
import com.entity.Static.Question8_Ex1.HinhChuNhat;
import com.entity.Static.Question8_Ex1.HinhHoc;
import com.entity.Static.Question8_Ex1.HinhHocException;
import com.entity.Static.Question8_Ex1.HinhTron;
import com.entity.Static.SecondaryStudent;
import com.entity.Static.Student;

import java.util.Scanner;

public class Exercise1_Static {
    public static Student[] students;

    public void Question1() {
        students = new Student[3];
        Student student1 = new Student(1, "Nguyen Van A");
        Student student2 = new Student(2, "Nguyen Van B");
        Student student3 = new Student(3, "Nguyen Van C");

        students = new Student[]{student1, student2, student3};

        for (Student std : students) {
            System.out.println(std);
        }
        System.out.println("------------");
        Student.setCollege("Đại học công nghệ");

        for (Student student : students) {
            System.out.println(student);
        }


    }

    public void Question2() {
        students = new Student[3];
        students[0] = new Student(1, "Nguyen Van A");
        students[1] = new Student(2, "Nguyen Van B");
        students[2] = new Student(3, "Nguyen Van C");


        System.out.println("Quy lop hien tai:" + Student.getMoneyGroup());

        System.out.println("Student 1 tiêu mất 50k");
        Student.setMoneyGroup(Student.getMoneyGroup() - 50);
        System.out.println("Quy lop hien tai:" + Student.getMoneyGroup());

        System.out.println("Student 2 tiêu mất 20k");
        Student.setMoneyGroup(Student.getMoneyGroup() - 20);
        System.out.println("Quy lop hien tai:" + Student.getMoneyGroup());

        System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm");
        Student.setMoneyGroup(Student.getMoneyGroup() - 150);
        System.out.println("Quy lop hien tai:" + Student.getMoneyGroup());

        System.out.println("cả nhóm mỗi người lại đóng quỹ mỗi người 50k");

        for (Student student : students) {
            student.setMoneyGroup(student.getMoneyGroup() + 50);
        }

        System.out.println("Quy lop hien tai:" + Student.getMoneyGroup());
    }

    public void Question3() {
        int max = MyMath.max(5, 7);
        System.out.println(max);

        int min = MyMath.min(7, 5);
        System.out.println(min);

        int sum = MyMath.sum(5, 7);
        System.out.println(sum);

    }

    public void Question4() {
        Student student = new Student(1, "Nguyen thi Chinh");
        System.out.println(student.toString());
        Student.setCollege("Đại Học Điện Lực");
        System.out.println("Ten Dai học sau khi thay doi: " + Student.getCollege());

    }

    public void Question5() {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();

        System.out.println("Số student được sinh ra la:" + Student.count);
    }

    public void Question6() {
        Student student1 = new PrimaryStudent();
        Student student2 = new PrimaryStudent();

        Student student3 = new SecondaryStudent();
        Student student4 = new SecondaryStudent();
        Student student5 = new SecondaryStudent();
        Student student6 = new SecondaryStudent();

        System.out.println("Số luong Student duoc sinh ra la: "+Student.count);
        System.out.println("Số luong primary Student duoc sinh ra la: "+PrimaryStudent.countPri);
        System.out.println("Số luong secondary Student duoc sinh ra la: "+SecondaryStudent.countSecond);
    }
    public void Question7()  {
        try{
            Student student1 = new Student();
            Student student2 = new Student();
            Student student3 = new Student();
            Student student4 = new Student();
            Student student5 = new Student();
            Student student6 = new Student();
            Student student7 = new Student();
            Student student8 = new Student();
            if(Student.count>7){
                throw new Exception("chi duoc nhap toi da 7 student");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void Question8() throws HinhHocException {

        HinhTron ht= new HinhTron();
        System.out.println("chu vi hinh tron la: "+ht.tinhChuVi(3));
        System.out.println("Dien tich hinh tron la: "+ht.tinhDienTich(3));

        HinhChuNhat hcn=new HinhChuNhat();
        System.out.println("chu vi hinh chu nhat la: "+ht.tinhChuVi(3,4));
        System.out.println("Dien tich hinh chu nhat la: "+ht.tinhDienTich(3,4));

        System.out.println("so luong hinh hoc duoc sinh ra la:"+HinhHoc.getCount());

        HinhHoc.setCount(0);
        System.out.println("Đã Set lai count = :"+HinhHoc.getCount());

        Scanner scanner=new Scanner(System.in);

        System.out.println("Nhap so luong Hinh hoc muon tao:");
        try{
            int n=scanner.nextInt();
            HinhHoc[] hinhHocs=new HinhHoc[n];
            for(int i=0;i<n;i++){
                hinhHocs[i]=new HinhHoc();
            }
        }
        catch (HinhHocException e){
            System.out.println(e.getMessage());
        }



    }
}
