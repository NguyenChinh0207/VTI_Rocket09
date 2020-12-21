/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.backend;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import java.time.LocalDate;
import java.time.Month;


public class Exercise1 {
    public void Question1(){
//        ko co para
        Department department1 = new Department();
        System.out.println(department1.getId());
        System.out.println(department1.getDepartmentName());
//        co para       
        Department department2=new Department("Nguyen thi chinh");
        System.out.println(department2.getId());
        System.out.println(department2.getDepartmentName());        
    }
    public void Question2(){
        Account account1=new Account();
        System.out.println("In Cau a:");
        System.out.println(account1.getId());
        System.out.println(account1.getEmail());
        System.out.println(account1.getUserName());
        System.out.println(account1.getDepartment());
        System.out.println(account1.getCreateDate());
        
        Account account2=new Account(1,"nchinh407@gmail.com", "NguyenChinh" ,"Nguyễn", "Chinh");
        System.out.println("In Cau b:");
        System.out.println(account2.getId());
        System.out.println(account2.getEmail());
        System.out.println(account2.getUserName());
        System.out.println(account2.getFullName());
        
        
        Position position1= new Position(1, "DEV");
        Position postion2=new Position(2,"TEST");
        Position postion3=new Position(3,"PM");
        Position postion4=new Position(4,"SCRUM_MASTER");
        
        Account account3=new Account(1,"nchinh407@gmail.com", "NguyenChinh" ,"Nguyễn", "Chinh",postion3);
        System.out.println("In Cau c:");
        System.out.println(account3.getId());
        System.out.println(account3.getEmail());
        System.out.println(account3.getUserName());
        System.out.println(account3.getFullName());
        System.out.println(account3.getCreateDate());
        
        Account account4=new Account(1,"nchinh407@gmail.com", "NguyenChinh" ,"Nguyễn", "Chinh",postion2,LocalDate.of(2020, 12, 13));
        System.out.println("In Cau d:");
        System.out.println(account4.getId());
        System.out.println(account4.getEmail());
        System.out.println(account4.getUserName());
        System.out.println(account4.getFullName());
        System.out.println(account4.getCreateDate());
    }
    public void Question3(){
        Group group = new Group();
	System.out.println(group.getId());
        System.out.println(group.getGroupName());
        System.out.println(group.getCreator());
        System.out.println(group.getCreateDate());
        
        Account account = new Account(1, "nchinh407@gmail.com", "nguyenchinh", "nguyen", "chinh");
        Account account1 = new Account(2, "n07@gmail.com", "nguyen05", "nguyen", "Lan");
        Account account2 = new Account(3, "mai@gmail.com", "nguyennh", "nguyen", "mai");
        Account[] accounts={account,account1,account2};
        Group group1=new Group("GroupName1", account, LocalDate.now(), accounts);
        
        String[] userNames= {"nguyenchinh", "nguyenmy","nguyenanh","hamai"};
        Group group2= new Group("GroupName2", account, userNames, LocalDate.now());
    }
}
