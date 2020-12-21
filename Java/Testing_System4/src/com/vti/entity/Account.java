/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.entity;

import java.time.LocalDate;


public class Account {
    private int             id;
    private String          email;
    private String          userName;
    private String          firstName;
    private String          lastName;
    private String          fullName;
    private Department      department;
    private Position        position;
    private LocalDate       createDate;
    private Group[]         groups;//1 account co the thuoc nhieu group

    public Account(){
    }
    public Account(int id, String email, String userName, String firstName, String lastName) {
        this.id = id;
        this.email=email;
        this.userName = userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.fullName = firstName+" "+lastName;
       
    }

    public Account(int id, String email, String userName, String firstName, String lastName, Position position) {
        this.id = id;
        this.email=email;
        this.userName = userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.fullName = firstName+" "+lastName;
        this.position=position;
        this.createDate=LocalDate.now();
    
    }
    public Account(int id, String email, String userName, String firstName, String lastName, Position position, LocalDate createDate) {
        this.id = id;
        this.email=email;
        this.userName = userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.fullName = firstName+" "+lastName;
        this.position=position;
        this.createDate=createDate;
    
    }

    Account(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    
}
