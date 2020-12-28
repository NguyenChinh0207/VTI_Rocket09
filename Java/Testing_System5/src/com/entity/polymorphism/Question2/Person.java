/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.polymorphism.Question2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class Person {
    private String name;
    private Gender gioiTinh;
    private LocalDate ngaySinh;
    private String diaChi;
    
    public Person() {
        
    }
    
    
    public Person(String name, Gender gioiTinh, LocalDate ngaySinh, String diaChi) {
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Gender gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public Scanner scanner=new Scanner(System.in);
    public void inputInfo(){
        System.out.println("Nhap ten: ");
        this.name= scanner.nextLine();
        System.out.println("Nhập giới tính (0: MALE,1: FEMAIE, Khac: UNKNOWN): ");
		int choose = scanner.nextInt();
		switch (choose) {
		case 0:
			this.gioiTinh = Gender.valueOf("MALE");
			break;

		case 1:
			this.gioiTinh = Gender.valueOf("FEMALE");
			break;

		default:
			this.gioiTinh = Gender.valueOf("UNKNOWN");
			break;
		}


        System.out.println("Nhap ngay sinh: VD:2020-07-23");
        this.ngaySinh=LocalDate.parse(scanner.nextLine());
        System.out.println("Nhap dia chi: ");
        this.diaChi= scanner.nextLine();
    }
    public void showInfo(){
        System.out.println("Ten: "+name);
        System.out.println("Gioi tinh: "+gioiTinh);
        System.out.println("Ngay sinh: "+ngaySinh);
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", scanner=" + scanner + '}';
    }
    
}
