/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class Group {
    private int         id;
    private String      groupName;
    private Account     creator;
    private LocalDate   createDate;
    private Account[]   accounts;
    public static Scanner scanner=new Scanner(System.in);
    public Account[] accountsList=new Account[100];
    public Group() throws InvalidAgeInputingException {

        System.out.println("Nhap id:");
        id=scannerUtils.inputInt("Please input a id as int, please input again.");
        System.out.println("Nhap group name:");
        groupName=scannerUtils.inputString("Please input a string, please input again.");
        System.out.println("Nhap creater:");
        groupName=scannerUtils.inputString("Please input a string, please input again.");

        System.out.println("Nhap date :");
        createDate=scannerUtils.inputDate("please correct format (yyyy-mm-dd)");

        inputAccount();

    }
//    public String getAccount(){
//        for(Account account:accountsList)
//        {
//            return account.getUserName();
//        }
//        return "null";
//    }
    @Override
    public String toString() {

        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                ", accounts=" + Arrays.toString(accounts) +

                '}';

    }

    public void inputAccount() throws InvalidAgeInputingException {
        System.out.println("Bạn có muôn thêm accounts không: 1 là có, 2 là không");
        int choose;
            do{
                choose=scannerUtils.inputInt("Please input a number as int 1 or 2, please input again");
                switch(choose){
                    case 1:
                        addAccount();
                        break;
                    case 2:
                        System.out.println("Không thêm account");
                        break;
                    default:
                        System.out.println("input must 1 or 2");
                        break;
                }
            }
            while(choose!=2);

    }
    public void addAccount() throws InvalidAgeInputingException {
        System.out.println("Nhập số lượng account muốn thêm");
        int n= scannerUtils.inputInt("Please input a number as int, please input again");
        for(int i=0;i<n; i++){
            accountsList[i]=new Account();
        }

    }

}
