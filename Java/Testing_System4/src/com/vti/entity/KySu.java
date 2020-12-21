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
public class KySu extends CanBo{
    private String nganhDaoTao;

    public KySu() {
        super();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Moi ban nhap vao nganh dao tao: ");
        nganhDaoTao=scanner.nextLine();
    }
    
    
    public KySu(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String nganhDaoTao) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.nganhDaoTao=nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }
    @Override
    public String toString(){
        return super.toString()+"\nKySu [nganhDaoTao="+nganhDaoTao+"]";

}
}
