/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.polymorphism.Question3;

/**
 *
 * @author May tinh Duy Toi
 */
public class HinhVuong extends HinhChuNhat{

    @Override
    public float tinhDienTich(float a, float b) {

        return super.tinhDienTich(a, b);
    }
    
    public float tinhDienTich(float a) {
        
        return this.tinhDienTich(a, a);
    }

    @Override
    public float tinhChuVi(float a, float b) {
        
        return super.tinhChuVi(a, b);
    }
    public float tinhChuVi(float a) {
        return this.tinhChuVi(a, a);
    }
}
