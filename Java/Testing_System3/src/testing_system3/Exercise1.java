/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_system3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void Question1(){
        Account account1=new Account();
        account1.luong=(float) 5240.5;
        
        Account account2=new Account();
        account2.luong=(float) 10970.055;
        System.out.println("Luong cua account1: " + account1.luong + "\nLuong cua acc2: " + account2.luong); 
        int lamTron1 = (int)account1.luong ;
        int lamTron2 = (int)account2.luong ;
        
        System.out.printf("Luong cua hai acc sau khi làm tròn là: Acc1: %d, Acc2:%d",lamTron1,lamTron2);
    }
    public static void Question2(){
        System.out.println("Nhap so :");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.printf("=> %05d",n);
    }
    public static void Question3(){
        System.out.println("Nhap so :");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.printf("=> %05d",n);
        int haiSoCuoi=n%100;
        System.out.printf("Hai so cuoi cua %05d la: ",n,haiSoCuoi);
        
    }
    public static void Question4(){
        
        Scanner scanner=new Scanner(System.in);       
        System.out.println("Nhap so nguyen a :");
        int a=scanner.nextInt();
        System.out.println("Nhap so nguyen b :");
        int b=scanner.nextInt();
        int thuong=a/b;
        System.out.printf("Thuong cua %d và %d la %d",a,b,thuong);
    }
    public static void main(String[] args) {
       Question1();
       Question2();
       Question3();
       Question4();
    }
    
}
