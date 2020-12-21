/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class Exercise3 {

    /**
     * @param args the command line arguments
     */
    public static void Question1(){
        System.out.println("Cau a");
        System.out.println("Nhap so nguyen duong n");
        Scanner scan=new Scanner(System.in);
        int n= scan.nextInt();
       
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.println("Cau b");
        for(int i=n;i>0;i--)
        {
           for(int j=0;j<i;j++)
             System.out.print("*");
           System.out.print("\n");
        }
        System.out.println("Cau c");
        for(int i = 0; i < n; i++) {
            for(int j=0; j<i; j++)
               System.out.print(" "); 
            for(int j=i; j < n; j++)
               System.out.print("*");
            System.out.print("\n");      
        }
        System.out.println("Cau d");
        
        for(int i=n;i>0;i--)
        {
            for(int j=0; j<i; j++)
               System.out.print(" "); 
            for(int j=i; j <= n; j++)
               System.out.print("*");
                      
           System.out.print("\n");
        }
        
    }
   
    public static void Question2(){
        int i, n;
        int gt = 1;
        System.out.println("Nhap so nguyen duong n:");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
 
        for(i = 1; i <= n; i++) 
        {
            gt = gt * i;
        }

        System.out.printf("%d! = %d\\n",n, gt);
        
       
    }
    public static void main(String[] args) {
        Question1();
        Question2();
        
    }
    
}
