/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_system3;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class Exercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Account accounts[]=new Account[5];
        
        for(int i=0;i<accounts.length;i++){
            accounts[i]=new Account();
            accounts[i].email="Email"+i+"  ";
            accounts[i].userName="useName"+i+"  ";
            accounts[i].fullName="Full Name"+i+"  ";
            accounts[i].createDate=LocalDate.now();
       
        }
        for(Account account: accounts){
            System.out.print("email:"+account.email);
            System.out.print("userName:"+account.userName);
            System.out.print("fullName:"+account.fullName);
            System.out.println("CreateDate:"+account.createDate);
        }
    }
    
}
