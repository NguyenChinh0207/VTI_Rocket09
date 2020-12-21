/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.entity;

import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public  abstract class CanBo {
    protected String hoTen;
    protected int tuoi;
    protected GioiTinh gioiTinh;
    protected String diaChi;

    public CanBo(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public CanBo() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Moi ban nhap vao ho ten: ");
        hoTen=scanner.nextLine();
        System.out.println("Moi ban nhap vao tuoi: ");
        tuoi=scanner.nextInt();
        
        System.out.println("Moi ban nhap vao gioi tinh:(1.Nam,2.Nu,3.Unknow)");        
        int gt=scanner.nextInt();
        switch(gt){
            case 1:
                gioiTinh=GioiTinh.MALE;
                break;
            case 2:
                gioiTinh=GioiTinh.FEMALE;
                break;    
            case 3:
                gioiTinh=GioiTinh.UNKNOW;
                break; 
        }
        System.out.println("Moi ban nhap vao dia chi: ");
        diaChi=scanner.nextLine();
    }
    
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getTuoi() {
        return tuoi;
    }
@Override
public String toString(){
        return "CanBo [hoten="+hoTen+", tuoi="+ tuoi+", gioitinh="+gioiTinh+", diachi="+diaChi+"]";

}
    
}
