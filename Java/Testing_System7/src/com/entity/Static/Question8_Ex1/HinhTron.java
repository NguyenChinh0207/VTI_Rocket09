package com.entity.Static.Question8_Ex1;

public class HinhTron extends HinhHoc{
    private static final float PI= (float) 3.14;

    public HinhTron() throws HinhHocException {
    }


    @Override
    public float tinhChuVi(float a, float b) {
       return super.tinhChuVi(a,b);
    }
    public float tinhChuVi(float a) {
        return 2*PI*a;
    }
    @Override
    public float tinhDienTich(float a, float b) {
        return super.tinhDienTich(a,b);
    }
    public float tinhDienTich(float a) {
        return PI*a*a;
    }
}
