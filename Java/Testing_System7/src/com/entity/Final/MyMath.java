package com.entity.Final;

public class MyMath {
    private static final float PI= (float) 3.14;

    public static float getPI() {
        return PI;
    }

    public static float sum(float a){
//        PI=(float)3.15;//khong thay doi đuoc so PI
        return a+getPI();
    }
}
