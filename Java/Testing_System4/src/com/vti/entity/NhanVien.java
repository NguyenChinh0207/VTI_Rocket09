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
public class NhanVien extends CanBo{
    private  String congViec;

    public NhanVien(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String congViec) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.congViec=congViec;
    }

    public NhanVien() {
        super();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Moi ban nhap vao cong viec: ");
        congViec=scanner.nextLine();
    }
    
    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }
     @Override
    public String toString(){
        return super.toString()+"\nNhanVien [congViec="+congViec+"]";

}
}
