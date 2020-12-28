/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.time.LocalDate;


public class Account {
    private int             id;
    private String          email;
    private String          userName;
    private String          fullName;
    private int             age;
    //private Department      department;
    //private Position        position;
//    private LocalDate       createDate;
    //private Group[]         groups;//1 account co the thuoc nhieu group

    public Account() throws InvalidAgeInputingException {
        System.out.println("Nhập id: ");
        id = scannerUtils.inputInt("Please input a number as int, please input again.");

        System.out.println("Nhập email: ");
        email = scannerUtils.inputString("Please input a email is string, please input again.");

        System.out.println("Nhập username: ");
        userName = scannerUtils.inputString("Please input a String, please input again.");

        System.out.println("Nhập fullname: ");
        fullName = scannerUtils.inputString("Please input a String, please input again.");

        System.out.println("Nhap tuoi:");
        age=inputAccountAge();
    }
    public static int inputAccountAge(){
            while (true) {
                try {
                    int age = scannerUtils.inputAge();
                    if (age < 18) {
                        System.out.println("Your age must be greater than 18, please input again.");
                    } else {
                        return age;
                    }
                } catch (InvalidAgeInputingException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    public static  int inputAge() throws InvalidAgeInputingException {
        while(true){
            int age = scannerUtils.inputInt("Please input an age as int, please input again.");
            if (age <= 0) {
                throw new InvalidAgeInputingException("The age must be greater than 0, input again");
            }
            else
                return age;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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





}
