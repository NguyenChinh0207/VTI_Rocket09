/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.entity;

import java.time.LocalDate;



public class Group {
    private int         id;
    private String      groupName;
    private Account     creator;
    private LocalDate   createDate;
    private Account[]   accounts;

    public Group() {
    }

    public Group(String groupName, Account creator, LocalDate createDate, Account[] accounts) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
        this.accounts = accounts;
    }
    public Group(String groupName, Account creator,String[] userName,LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        Account[] accounts=new Account[userName.length];
        for(int i=0;i<userName.length;i++){
            accounts[i]=new Account(userName[i]); 
        }
        this.createDate = createDate;
      
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Account getCreator() {
        return creator;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
    
}
