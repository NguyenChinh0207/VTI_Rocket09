/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.abstraction;

/**
 *
 * @author May tinh Duy Toi
 */
public class KhoiThi {
    private String tenKhoiThi;
    private String tenMonThi;

    public KhoiThi() {
    }

    public KhoiThi(String tenKhoiThi, String tenMonThi) {
        this.tenKhoiThi = tenKhoiThi;
        this.tenMonThi = tenMonThi;
    }

    public String getTenMonThi() {
        if(tenKhoiThi.equals("A"))
            tenMonThi="Toan, Ly, Hoa";
        else if(tenKhoiThi.equals("B"))
            tenMonThi="Toan, Hoa, SInh";
        else if(tenKhoiThi.equals("C"))
            tenMonThi="Van, Su, Dia";
        return tenMonThi;
    }

    public void setTenMonThi(String tenMonThi) {
        this.tenMonThi = tenMonThi;
    }

    
    public String getTenKhoiThi() {
        return tenKhoiThi;
    }

    public void setTenKhoiThi(String tenKhoiThi) {
        this.tenKhoiThi = tenKhoiThi;
    }

   

   
    
    
    
}
