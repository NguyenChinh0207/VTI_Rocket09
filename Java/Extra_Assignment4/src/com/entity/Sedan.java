/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author May tinh Duy Toi
 */
public class Sedan extends Car{
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Sedan(int length, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        if(length>20){
            regularPrice=regularPrice*0.05;
        }
        else{
            regularPrice=regularPrice*0.1;
        }
        return 0;
        
    }
    
   
}
