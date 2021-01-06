package com.frontend;

import com.backend.Ex3_InnerClass;

public class Exercise3_Program {
    public static void main(String[] args) {
        Ex3_InnerClass ex3=new  Ex3_InnerClass();
        ex3.Question1();
        ex3.Question2();
        ex3.Question3();
        //output:
        //java: cannot find symbol
        //  symbol:   class InnerClass
        //  location: class com.backend.Ex3_InnerClass
        //sau khi sua loi chuong trinh, output la:
        //Day la inner class
        //Day la inner class
        ex3.Question4();
        //output :
        // Ngày:31/10/2017
        //Giờ:10:15:30
    }
}
