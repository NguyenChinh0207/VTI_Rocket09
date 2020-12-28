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
public class Ford extends Car{
    private int year;
    private int manufacturerDiscount;

    public Ford(int year, int manufacturerDiscount, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public void setManufacturerDiscount(int manufacturerDiscount) {
        this.manufacturerDiscount = manufacturerDiscount;
    }

    @Override
    public double getSalePrice() {
        return super.getSalePrice()-manufacturerDiscount; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
