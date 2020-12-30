package com.entity.Static;

public class MyMath {

    public static int max(int a, int b){
        if(a>b)
            return a;
        else if(a<b)
            return b;
        return a;
    }
    public static int min(int a, int b){
        if(a>b)
            return b;
        else if(a<b)
            return a;
        return a;
    }
    public static int sum(int a, int b){
        return a+b;
    }

}
