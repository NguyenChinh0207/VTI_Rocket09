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
public class Truck extends Car{
    private int weight;

    public Truck(int weight, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public double getSalePrice(){
        if(weight>2000){
            regularPrice=regularPrice*0.1;
        }
        else{
            regularPrice=regularPrice*0.2;
        }
        return 0;
    
    }
}
