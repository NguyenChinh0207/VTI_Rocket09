/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;


public class Account {
    private int accountID;
    private String email;
    private String userName;
    private String fullName;
    private LocalDate createDate;
    private static int counter = 0;

    public Account() {
    }

    public Account(String email, String userName, String fullName, LocalDate createDate) {
        this.accountID = ++counter;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.createDate = createDate;
    }


    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "|" +
                "accountID=" + accountID +
                "| email='" + email + '\'' +
                "| userName='" + userName + '\'' +
                "| fullName='" + fullName + '\'' +
                "| createDate=" + createDate +
                '|';
    }
}
