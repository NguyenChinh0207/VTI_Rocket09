/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.abstraction;

import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class ThiSinh {
    private String sbd;
    private String hoTen;
    private String diaChi;
    private int mucUuTien;
    private KhoiThi khoiThi;

    public ThiSinh(String sbd, String hoTen, String diaChi, int mucUuTien, KhoiThi khoiThi) {
        this.sbd = sbd;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
        this.khoiThi = khoiThi;
    }

    public ThiSinh() {
    }
    
    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMucUuTien() {
        return mucUuTien;
    }

    public void setMucUuTien(int mucUuTien) {
        this.mucUuTien = mucUuTien;
    }

    public KhoiThi getKhoiThi() {
        return khoiThi;
    }

    public void setKhoiThi(KhoiThi khoiThi) {
        this.khoiThi = khoiThi;
    }
    
    public void inputInfor(){
        Scanner scanner = new Scanner(System.in);

	System.out.println("Nhập số báo danh thi sinh: ");
	sbd = scanner.nextLine();

	System.out.println("Nhập họ tên: ");
	hoTen = scanner.nextLine();

	System.out.println("Nhập địa chỉ: ");
	diaChi = scanner.nextLine();

	System.out.println("Nhập mức ưu tiên: ");
	mucUuTien = scanner.nextInt();

	System.out.println("Nhập khối thi (A(Toan, ly, Hoa)||B(Toan, hoa , sinh)||C(Van, su , dia)");
	khoiThi = new KhoiThi();
	khoiThi.setTenKhoiThi(scanner.nextLine());

    }
    

    @Override
    public String toString() {
        return "ThiSinh{" + "sbd=" + sbd + ", hoTen=" + hoTen  + ", diaChi=" + diaChi + 
				", mucUuTien=" + mucUuTien + ", khoi thi=" + khoiThi.getTenKhoiThi()+ '}';

    }
    
}
