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
public class Exercise1 {

  
    
//    Viết chương trình nhập vào một số thực. Đơn vị tính cho số này là centimet
//(cm).
//Hãy in ra số tương đương tính bằng foot (số thực, có 2 số lẻ thập phân) và inch
//(số thực, có 2 số lẻ thập phân).
//Với 1 inch = 2.54 cm và 1 foot = 12 inches.
    public static void Question1(){
        Scanner scan =new Scanner(System.in);
        System.out.println("Nhap vao 1 so thuc");
        float x = scan.nextFloat();
        
        System.out.printf("đơn vi inch: %.2f",x/2.54);
        System.out.printf("\nđơn vi foot: %.2f",x/12/2.54);
        scan.close();    
    }
   
//    Viết chương trình nhập vào số giây từ 0 tới 68399, đổi số giây này thành dạng
//[giờ:phút:giây], mỗi thành phần là một số nguyên có 2 chữ số.
    public static void Question2(){
        System.out.println("\nNhap vao so giay tu 0 den 68399:");
        Scanner scan =new Scanner(System.in);        
        int x = scan.nextInt();        
            if(x<0){
                System.out.println("\nKhông duoc nhap nho hon 0");
            }
            else if(x>68399){
                System.out.println("\nKhông duoc nhap lon hon 68399");
            }
            else{
                int gio=x/3600;
                int phut= (x%3600)/60;
                int giay= (x%3600)%60;
                System.out.printf("\nGio:phut:giay la :\n%02d : %02d : %02d", gio,phut,giay);
            }
        scan.close();
    }
    
//    Question 3:
//Viết chương trình nhập vào 4 số nguyên.
//Hiển thị ra số lớn nhất và nhỏ nhất
    public static void Question3(){ 
        Scanner scan =new Scanner(System.in); 
      
        int[] A=new int[4];
        
        for(int i=0;i<4;i++){
            System.out.println("Nhap vao so nguyen thu "+(i+1) + " : ");
            A[i]=scan.nextInt();
        }
        int max= A[0];
        int min=A[0];
        for(int i=1;i<4;i++){
            if(A[i]>max){
                max=A[i];
            }
            if(A[i]<min){
                min=A[i];
            }
        }
        System.out.println("So lon nhat la: "+max);
        System.out.println("So nho nhat la : "+min);
      
    }
 
 //Question 4: Nhập vào hai số tự nhiên a và b. Tính hiệu của hai số đó.
    public static void Question4(){
        Scanner scan =new Scanner(System.in);
        System.out.println("Nhap vao 2 so nguyen:");
        int a=scan.nextInt();
        int b=scan.nextInt();
        if(a-b>0){
            System.out.println("So thu nhat lon hon so thu hai");
        }
        else if(a-b<0){
             System.out.println("So thu nhat nho hon so thu hai");
        }
    }
 //   Question5 Nhập vào 2 số tự nhiên a và b. Kiểm tra xem a có chia hết cho b không
    public static void Question5(){
        Scanner scan =new Scanner(System.in);
        System.out.println("Nhap vao 2 so nguyen:");
        int a=scan.nextInt();
        int b=scan.nextInt();
        if(a%b==0){
            System.out.println("So thu nhat chia het cho so thu hai");
        }
        else{
             System.out.println("So thu nhat khong chia het so thu hai");
        }
    }
    
     public static void Question6(){
        Scanner scan =new Scanner(System.in);
        System.out.println("Nhap vao diem ba mon hoc Toan ly Hoa:");
        float diemT=scan.nextInt();
        float diemL=scan.nextInt();
        float diemH=scan.nextInt();
        float diemtb= (diemT*2 +diemL +diemH)/4;
        System.out.printf("Diem trung binh la :%.2f\n",diemtb);
//        if(diemtb>=9.0){
//            System.out.println("Loai xuat sac");
//        }
//        else if(diemtb>=8.0 && diemtb<9.0){
//            System.out.println("Loai gioi");
//        }
//        else if(diemtb>=7.0 && diemtb<8.0){
//            System.out.println("Loai kha");
//        }
//        else if(diemtb>=6.0 && diemtb<7.0){
//            System.out.println("Loai trung binh kha");
//        }
//        else if(diemtb>=5.0 && diemtb<6.0){
//            System.out.println("Loai trung binh");
//        }
//        else if(diemtb<5.0){
//            System.out.println("Loai kem");
//        }
         if(diemtb<5.0){
            System.out.println("Loai kem");
        }
         if(diemtb<6.0){
            System.out.println("Loai trung binh");
        }
         if(diemtb<7.0){
            System.out.println("Loai trung binh kha");
        }
         if(diemtb<8.0){
            System.out.println("Loai kha");
        }
         if(diemtb<9.0){
            System.out.println("Loai gioi");
        }
    }    
      public static void main(String[] args) {
        
//        Question1();
//        Question2();
//        Question3();
//        Question4();
//        Question5();
        Question6();
    }
}
