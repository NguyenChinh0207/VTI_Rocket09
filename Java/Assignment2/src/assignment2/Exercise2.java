/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author May tinh Duy Toi
 */
public class Exercise2 {
    private static Scanner scanner=new Scanner(System.in);
   
// Question1  Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1 .
//Hãy liệt kê các phần tử xuất hiện trong dãy đúng một lần 
//   
    
    public static void Question1(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Nhap so luong phan tu: ");
        int n= scan.nextInt();
        float[] arr= new float[n];
        for(int i=0;i<n;i++){
            System.out.println("Nhap phan tu thu "+(i+1)+"");
            arr[i]=scan.nextFloat();
        }
        System.out.println("Cac phan tu xuat hien 1 lan la: ");
       
        for(int i=0;i<n;i++){
            if(countXH(arr, n, arr[i])==1){
                     System.out.println(" " + arr[i]);
                }
        }
        
    }
    public static int countXH(float A[],int n, float x){
        int count=0;
        for(int j=0;j<n;j++){
            if(A[j]==x)
                count++;
        }
        return count;
    }
    
//    Question2:Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1.
//Hãy liệt kê các phần tử xuất hiện trong dãy đúng 2 lần.
    public static void Question2(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Nhap so luong phan tu: ");
        int n= scan.nextInt();
        float[] arr= new float[n];
        for(int i=0;i<n;i++){
            System.out.println("Nhap phan tu thu "+(i+1)+"");
            arr[i]=scan.nextFloat();
        }
        System.out.println("Cac phan tu xuat hien 2 lan la: ");
       
        for(int i=0;i<n;i++){
            if(countXH(arr, n, arr[i])==2 && countXH(arr, i, arr[i])==0){
                     System.out.println(" " + arr[i]);
                }
        }
    }
//    Q3:Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1 .
//In ra màn hình số lần xuất hiện của các phần tử.
    public static void Question3(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Nhap so luong phan tu: ");
        int n= scan.nextInt();
        float[] arr= new float[n];
        for(int i=0;i<n;i++){
            System.out.println("Nhap phan tu thu "+(i+1)+"");
            arr[i]=scan.nextFloat();
        }
        System.out.println("Giatri \t\tso lan\n");
      for(int i=0;i<n;i++){
            if(countXH(arr, i, arr[i])==0){                   
                     System.out.printf("%.2f\t\t%d\n",arr[i],countXH(arr, n, arr[i]));
                }
        }
    }
//    Q4:Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ.
//Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32  
    public static void Question4(){
        int n,tong=0;
        System.out.println("nhap vao so nguyen n: ");
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        while (n>0) {
            tong+=n%10;
            n= n/10;
        }
        System.out.println("tong cac chu so cua n la: "+tong);
    }
//    Q5:Viết chương trình phân tích một số nguyên thành các thừa số nguyên tố
//Ví dụ: Số 28 được phân tích thành 2 x 2 x 7
   
    public static void Question5(){
        int n= new Scanner(System.in).nextInt();
        int i=2;
        if(n==1){
            System.out.println(n+" = "+n);
        }
        else{
            System.out.print(n+" = ");
            while(n!=1){
                if(n%i==0){
                    System.out.print(i+" x ");
                    n=n/i;
                }
                else{
                    ++i;
                }
            }
            System.out.print("\b\b\b");
        }
    }
    
//    Question 6:
//Viết chương trình liệt kê tất cả các số nguyên tố nhỏ hơn n cho trước.
    public static boolean isPrime(int n) {      
        if (n < 2) {
            return false;
        }     
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void Question6(){
        System.out.print("Nhập n = ");
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("Tất cả các số nguyên tố nhỏ hơn %d là: \n", n);
        if (n >= 2) {
            System.out.print(2);
        }
        for (int i = 3; i < n; i+=2) {
            if (isPrime(i)) {
                System.out.print(" " + i);
            }
        }
    }
    
//    Question 7:
//Viết chương trình liệt kê n số nguyên tố đầu tiên.
    public static void Question7(){
        System.out.print("Nhập n = ");
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        System.out.printf("%d số nguyên tố đầu tiên là: \n", n);
        int dem = 0; 
        int i = 2;   
        while (dem < n) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                dem++;
            }
            i++;
        }
    }
//    Question 8:
//Viết chương trình tìm ước số chung lớn nhất, bội số chung nhỏ nhất của hai số
//tự nhiên a và b.
    public static int USCLN(int a, int b) {
        while(a!= b){
            if(a>b) a= a-b;
            else b= b-a;
        }
        return (a);
    }
    public static void Question8(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập số nguyên duong a = ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên duong b = ");
        int b = scanner.nextInt();
        while ((a <= 0) || (b <= 0)) {
            System.out.println("Nhập lại hai số nguyên dương!");
            System.out.print("Nhập số nguyên duong a = ");
            a = scanner.nextInt();
            System.out.print("Nhập số nguyên duong b = ");
            b = scanner.nextInt();
        }
        
        System.out.println("USCLN của " + a + " và " + b + " là: " + USCLN(a, b));
        System.out.println("BSCNN của " + a + " và " + b + " là: " + ((a * b) / USCLN(a, b)));
    }
//    Q9:Dãy số Fibonacci được định nghĩa như sau:
//
//F0 =1, F1 = 1; Fn = Fn-1 + Fn-2 với n>=2.
//
//Hãy viết chương trình tìm số Fibonacci thứ n.
    public static int fib(int n){
        if(n==0 || n==1) 
		return 1;
	else
		return (fib(n-2)+fib(n-1));
    }
    public static void Question9(){      
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();   
        System.out.println("So Fibonanci thu "+n+" la: f["+n+"]= "+fib(n));
        
    }
    
//    Q10:Một số được gọi là số thuận nghịch độc nếu ta đọc từ trái sang phải hay từ
//phải sang trái số đó ta vẫn nhận được một số giống nhau.
//Hãy liệt kê tất cả các số thuận nghịch độc có sáu chữ số (Ví dụ số: 558855).
    
    public static boolean isThuanNghich(int n) {
        StringBuilder xau = new StringBuilder();
              String str = "" + n;
              xau.append(str);
              String check = "" + xau.reverse();
              if (str.equals(check))
                     return true;
              else
                     return false;
    }
    public static void Question10(){
         int i, count = 0;
              for (i = 100000; i <= 999999; i++) {
                     if (isThuanNghich(i)) {
                            System.out.println(i);
                           count++;
                     }
              }
              System.out.println("Có " + count + " số thuận nghịch có 6 chữ số.");
       }
//Question 12:
    
    public static float[] InputArr(float[] arr) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
       
        arr = new float[n];
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
    public static void ASC(float [] arr) {
        float temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static float[] merge(float[] a, float[] b) {
        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        int cIndex = a.length + b.length - 1;
        float[] c = new float[cIndex + 1];
         
        // sắp xếp các mảng theo thứ tự tăng dần
        ASC(a);
        ASC(b);
         
        // trộn mảng a và b thành c
        for (int i = cIndex; i > -1; i--) {
            if (aIndex > -1 && bIndex > -1) {
                if (a[aIndex] > b[bIndex]) {
                    c[i] = a[aIndex--];
                } else {
                    c[i] = b[bIndex--];
                }
            } else if (bIndex == -1) {
                c[i] = a[aIndex--];
            } else if (aIndex == -1) {
                c[i] = b[bIndex--];
            }
        }
        return c;
    }
    public static void showArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void Question12(){
        float[] a = null;
        float[] b = null;
        float[] c = null;
 
        System.out.println("Nhập mảng a");
        a = InputArr(a);
        System.out.println("Nhập mảng b");
        b = InputArr(b);
         
        // trộn mảng a và b thành c
        c = merge(a, b);
         
        // in mảng c ra màn hình
        showArr(c);
       }
    
//    Question13:
    public static void Question13(){
       Scanner scanner=new Scanner(System.in);
       int n= scanner.nextInt();
       float[] Arr=new float[n];
       for(int i=0;i<n;i++){
           Arr[i]=scanner.nextFloat();
       }
    }
//    Question14:
    public static void Question14(){
       Scanner scanner=new Scanner(System.in);
       System.out.print("Nhập số tự nhiên n = ");
        int n = scanner.nextInt();
        System.out.printf("Các số fibonacci nhỏ hơn %d và "
                + "là số nguyên tố: ", n);
        int i = 0;
        while (fib(i) < 100) {
            int fi = fib(i);
            if (isPrime(fi)) {
                System.out.print(fi + " ");
            }
            i++;
        }
    }
    
    //    Question15:
    public static void Question15(){
        Question4();
        Question6();
    
    }
     //    Question16:
    public static void Question16(){
        System.out.println("Nhâp n:");
        int n=scanner.nextInt();
        int dem = 0;
        System.out.print("Cac ươc : ");
        for (int i = 1; i <= n; i++)
        {
            if (n % i == 0){
                System.out.print(i+"\t");
                dem++;
            }
        }
        System.out.printf("\n%d co Số ước là %d ",n,dem);
        System.out.printf("\n%d co cac ước là so nto la : ",n);
        for(int i=1;i<=n;i++){
            if (n % i == 0 && isPrime(i)){
                System.out.print(i+"\t");
            }
        }
    }
     //    Question17:
    public static void Question17(){
        System.out.println("Cac so co 7 chu so la snt la");
        for(int i=1000000;i<=9999999;i++){
            if(isPrime(i))
                System.out.print(i+" ");
        }
        System.out.println("Cac so co 7 chu so la so thuan nghich la");
        for(int i=1000000;i<=9999999;i++){
            if(isThuanNghich(i))
                System.out.print(i+" ");
        }
//        System.out.println("cac so co tong cac chu so la 1 so thuan nghich là");
//        int tong=0;
//        for(int i=1000000;i<=9999999;i++){
//           while (i>0) {
//            tong+=i%10;
//            i= i/10;
//            
//        }
//           if(isThuanNghich(tong))
//               System.out.print(tong+" ");
//        }
    }
    
//    Question18=Question19
//    Question 19:
   public static void DESC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
   
    public static void Question19(){
        Scanner scanner=new Scanner(System.in);
        Random ran = new Random();
        int n=100;
        int arr[]=new int[n];
        System.out.println("random 0 number bettween 100");
        for(int i=0;i<arr.length;i++){
            arr[i]=ran.nextInt(100);
            System.out.println(arr[i]);
        }
        
        int max1=arr[0];
        int vtmax1=0;
        for(int i=0; i<n;i++){
            if(arr[i]>max1){
                max1=arr[i];      
                vtmax1=i+1;
            }            
        }
	System.out.print("Phan tu lon nhat la : "+max1);	
        System.out.println(", co vi tri la: "+vtmax1);
        int max2=0; int vtmax2=0;
        for(int i=0;i<n;i++){
            if(arr[i]==max1 && i!=(vtmax1-1)){
                max2=arr[i];
                vtmax2=i+1;
                break;
            }
            else if(arr[i]>max2 && i!=(vtmax1-1)){
                max2=arr[i];
                vtmax2=i+1;
            }
        }
        System.out.print("Phan tu lon thu 2 la : "+max2);	
        System.out.println(", co vi tri la: "+vtmax2);
        
        DESC(arr);
        System.out.println("Dãy số được sắp xếp giảm dần: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

         
    }
//     Q20;Viết chương trình thực hiện chuẩn hoá một xâu ký tự nhập từ bàn phím (loại bỏ
//các dấu cách thừa, chuyển ký tự đầu mỗi từ thành chữ hoa, các ký tự khác thành
//chữ thường)
    
    
    public static void Question20() {
	String s0= new String();
      
        System.out.println("nhap xau: ");
        s0= scanner.nextLine();
        StringBuilder kq= new StringBuilder();
        StringTokenizer tg= new StringTokenizer(s0);
        while(tg.hasMoreTokens()){
            char arr[]= tg.nextToken().toCharArray();
            arr[0]= Character.toUpperCase(arr[0]);
            for(int i=1;i<arr.length;i++) arr[i]= Character.toLowerCase(arr[i]);
            kq.append(arr); kq.append(" ");
            
            
        }
 
        System.out.println("xau sau khi chuan hoa la: "+kq);


	}
    
//    Question 21:
    public static void Question21() {
	 String s0= new String();
       
        System.out.println("nhap xau ban dau: ");
        s0= scanner.nextLine();
        String arr[]= new String[20];
        int max=1; int n=0;
        StringTokenizer s1= new StringTokenizer(s0);
        while(s1.hasMoreTokens()){
            arr[n]= s1.nextToken();
            n++;
        }
        for(int i=0;i<n;i++){
            if(arr[i].length()>max) max=arr[i].length();
        }
        System.out.println("do dai cua tu lon nhat la: " +max);
        System.out.println("vi tri cac tu co do dai lon nhat la: ");
        for(int i=0;i<n;i++) if(arr[i].length()==max) System.out.println("  "+i);


	}
    
    public static void main(String[] args) {
            Question1();
            Question2();
            Question3();
            Question4();
            Question5();
            Question6();
            Question7();
            Question8();
            Question9();
            Question10();
            Question12();
            Question13();
            Question14();
            Question15();
            Question16();
            Question17();
//            Question18();
            Question19();
            Question20();
            Question21();

    }
    
}
