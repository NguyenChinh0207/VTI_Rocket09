/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;


import java.util.Locale;
import java.util.Scanner;

public class Position {

    private int             id;
    private PositionName positionName;

    public Position(int id, PositionName positionName) {
        this.id = id;
        this.positionName = positionName;
    }
    public static Scanner scanner=new Scanner(System.in);
    public Position() {
        System.out.println("Nhap id:");
        id=scannerUtils.inputInt("Please input a number as int, please input again.");
        System.out.println("Nhap PostionName:");
        positionName=PositionName.valueOf(inputPositionName("Please input as positionName (DEV,TEST,SCRUM_MASTER,PM), please input again"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String inputPositionName(String errorMessage) {
        while(true){
                String input=scanner.nextLine();
                if(input.toUpperCase()==String.valueOf(PositionName.values())){
                    return input;
                }
                else{
                    System.out.println(errorMessage);
                }

        }

    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }
}

