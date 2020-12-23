/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend;

import static com.backend.Ex1_Abstract.loadMenu;
import com.entity.polymorphism.Question1.Student;
import com.entity.polymorphism.Question3.HinhChuNhat;
import com.entity.polymorphism.Question3.HinhVuong;
import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */


public class Ex2_Polymorphism {
   
    private Scanner scanner;
    public Ex2_Polymorphism(){
        scanner=new Scanner(System.in);
    }
    
    public void Question1(){
        Student student=new Student();
        int choose = 0;
        do{
            loadMenu();
            choose = scanner.nextInt();

            switch (choose){
                case 1:
                    student.createStudent();
                    break;
                case 2:
                    student.caLopDiDiemDanh();
                    break;
                case 3:
                    student.nhom1DiHocBai();
                  
                    break;
                case 4:
                    student.nhom2DiDonVS();
                    break;
            }

        }while(choose != 4);
    }
    public static void loadMenu(){
        System.out.println("---------------");
        System.out.println("1 - Tao 10 hoc sinh , chia lam 3 nhom");
        System.out.println("2 - Keu goi car lop diem danh");
        System.out.println("3 - Nhom 1 di hoc bai");
        System.out.println("4 - Nhom 2 di don ve sinh");
        System.out.println("---------------");
    }
    
//    Question
    public void Question3(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap cạnh hinh chu nhat");
        float a=scanner.nextFloat();
        float b=scanner.nextFloat();
        
        HinhChuNhat hcn=new HinhChuNhat();
        System.out.println("Chu vi hinh chu nhat la:");
        System.out.println(hcn.tinhChuVi(a, b));
        System.out.println("Dien tich hinh chu nhat la:");
        System.out.println(hcn.tinhDienTich(a, b));
        
        System.out.println("Nhap cạnh hinh vuong");
        float x=scanner.nextFloat();
        
        HinhVuong hv=new HinhVuong();
        System.out.println("Chu vi hinh vuong la:");
        System.out.println(hv.tinhChuVi(a));
        System.out.println("Dien tich hinh vuong la:");  
        System.out.println(hv.tinhDienTich(a));
    }
    
}
