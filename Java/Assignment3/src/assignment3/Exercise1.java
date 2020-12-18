/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class Exercise1 {

    /**
     * @param args the command line arguments
     */
   private static Scanner scanner=new Scanner(System.in);
//    Q1:Nhập vào dãy n số thực. Tính tổng dãy, trung bình dãy, tổng các số âm,
//dương và tổng các số ở vị trí chẵn, vị trí lẻ trong dãy.
    public static void Question1(){
        System.out.println("Nhap n:");
        int n=scanner.nextInt();
        float Arr[]=new float[n];
        System.out.println("Nhap cac phan tu trong day");
        for(int i=0;i<n;i++){
            Arr[i]=scanner.nextFloat();
        }
        float tong = 0, tb,tongsoam=0, tongsovtchan=0, tongsovtle=0;
        for(int i=0; i<n;i++){
            tong=tong+Arr[i];
            if(Arr[i]<0){
                tongsoam=tongsoam+Arr[i];
            }
            if(i%2==0){
                tongsovtchan=tongsovtchan+Arr[i];
            }
            if(i%2!=0){
                tongsovtle=tongsovtle+Arr[i];
            }
        }
        System.out.println("Tong cac so trong day la:"+tong);
        System.out.println("Trung binh cac so trong day la:"+tong/n);
        System.out.println("Tong cac so am trong day la:"+tongsoam);
         System.out.println("Tong cac so o vi tri chan trong day la:"+tongsovtchan);
         System.out.println("Tong cac so o vi tri le trong day la:"+tongsovtle);
    }
    
//   Question 2:
//Tìm và chỉ ra vị trí xuất hiện đầu tiên của phần tử x trong dãy. 
    
    
    public static void main(String[] args) {
//            Question1();
//            Question2();
//            Question3();
//            Question4();
//            Question5();
    }
    
}
