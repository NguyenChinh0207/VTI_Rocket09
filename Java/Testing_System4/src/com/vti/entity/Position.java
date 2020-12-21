/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.entity;


public class Position {
    private int             id;
    private String    positionName;
    
    public Position(int id,String positionName){
        this.id=id;
        this.positionName=positionName;
    }

   

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }
    
}
enum PositionName{
    DEV,TEST,SCRUM_MASTER,PM
}
