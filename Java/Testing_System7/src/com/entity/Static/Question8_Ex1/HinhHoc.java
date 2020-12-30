package com.entity.Static.Question8_Ex1;

public class HinhHoc implements IHinhHoc {
    private float a;
    private float b;
    private static int count = 0;

    public HinhHoc(float a, float b) {
        this.a = a;
        this.b = b;

    }

    public HinhHoc() throws HinhHocException {
        count++;
        if(count>Configs.getSoLuongHinhHoc()){
            throw new HinhHocException("Số lượng hình hoc tối đa là:" +
                    Configs.getSoLuongHinhHoc());
        }
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        HinhHoc.count = count;
    }

    @Override
    public float tinhChuVi(float a, float b) {
        return 2*(a+b);
    }

    @Override
    public float tinhDienTich(float a, float b) {
        return a*b;
    }
}
