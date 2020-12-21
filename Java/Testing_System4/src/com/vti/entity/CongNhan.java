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
public class CongNhan extends CanBo{
    private int bac;

    public CongNhan() {
        super();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Moi ban nhap vao bac: ");
        bac=scanner.nextInt();
        
    }
    
    public CongNhan(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac=bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }
    @Override
public String toString(){
        return super.toString()+"\nCongNhan [bac="+bac+"]";

}
}
