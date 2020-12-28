/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.polymorphism.Question2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class Student extends Person{
    private int maSV;
    private float diemTB;
    private String email;

    public Student(int maSV, float diemTB, String email, String name, Gender gioiTinh, LocalDate ngaySinh, String diaChi) {
        super(name, gioiTinh, ngaySinh, diaChi);
        this.maSV = maSV;
        this.diemTB = diemTB;
        this.email = email;
    }

    public Student() {
        
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void showInfo() {
        System.out.println("Mã sinh viên: " + maSV);
	super.showInfo();
	System.out.println("Điểm trung bình: " + diemTB);
	System.out.println("Email: " + email);
    }

    @Override
    public String toString() {
        return "Student{" + "maSV=" + maSV + ", diemTB=" + diemTB + ", email=" + email + '}';
    }
    
    @Override
    public void inputInfo() {
      
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap ma sinh vien:");
        this.maSV=scanner.nextInt();
        
        super.inputInfo(); 
        
        System.out.println("Nhap diem trung binh:");
        this.diemTB=scanner.nextFloat();
        
        System.out.println("Nhap email:");
        this.email=scanner.nextLine();
    }
    public boolean isGetHocBong(){
        return diemTB>=8;
    }
    
    
}
