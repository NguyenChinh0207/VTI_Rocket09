/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_system3;

import static java.awt.Event.TAB;
import java.util.Scanner;


/**
 *
 * @author May tinh Duy Toi
 */
public class Ex4_String {

    /**
     * @param args the command line arguments
     */
   public static Scanner scanner=new Scanner(System.in);
//    Question 1:
//Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//thể cách nhau bằng nhiều khoảng trắng );
   public static int countWords(String s){
    int wordCount = 0;
    boolean Word = false;
    int endOfLine = s.length() - 1;

    for (int i = 0; i < s.length(); i++) {
        // neu char la 1 chu cai , word =true
        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
            Word = true;
            // neu char ko phai la chu cai va da co  chu cai truoc do
            // counter tang len.
        } else if (!Character.isLetter(s.charAt(i)) && Word) {
            wordCount++;
            Word = false;
            // tu cuoi cung cua chuoi neu no ko ket thuc bang char
            // 
        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
            wordCount++;
        }
    }
    return wordCount;
}
    public static void Question1(){
        
        System.out.println("Nhap chuoi:");
        String str=scanner.nextLine();
        System.out.print("Số từ của chuỗi là: "
                + countWords(str));
//cach2
//            str = str.trim();
//            str = str.replaceAll("\\s+", " ");
//            String[] words= str.split(" ");
//            for(int i=0;i<words.length;i++){
//                System.out.println(" in: "+words[i]);
//            }
//            System.out.print("Số từ của chuỗi là: "+words.length);
    }
    // Question 2:
// Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
    public static void Question2(){
      
        System.out.println("Nhap xau 1:");
        String s1=scanner.nextLine();
        
        System.out.println("Nhap xau 2:");
        String s2=scanner.nextLine();
        
        System.out.println("Chuoi sau khi noi la:"+s1.concat(s2));
        scanner.close();
    }
    // Question 3:
// Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chưa
// viết hoa chữ cái đầu thì viết hoa lên
    public static void Question3(){
        System.out.println("Nhap ten:");
        String name=scanner.nextLine();
        name=name.substring(0, 1).toUpperCase()+name.substring(1);
        System.out.println(name);
    }
//    Question 4:
//Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
//của người dùng ra
    public static void Question4(){
        System.out.println("Nhap ten:");
        String name=scanner.nextLine();
        name = name.toUpperCase();

        for(int i=0;i<name.length();i++){
            System.out.println("ký tự thứ "+(i+1)+" la: "+name.charAt(i));
        }
    }
    // Question 5:
	// Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
	// dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
    public static void Question5(){
        System.out.println("Nhap ho:");
        String name1=scanner.nextLine();
        
        System.out.println("Nhap ten:");
        String name2=scanner.nextLine();
        
        System.out.println("Ho ten day du la: "+(name1.concat(name2)));
    }
    // Question 6:
	// Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
	// sau đó hệ thống sẽ tách ra họ, tên , tên đệm
    public static void Question6(){
        System.out.println("Nhap ho va ten day du:");
        String fullName=scanner.nextLine();
        fullName=fullName.trim();//xoa dau cach o dau cuoi chuoi
        String[] words = fullName.split(" ");
	String lastName = words[0];
	String firstName = words[words.length - 1];
        String middleName="";
	for (int i = 1; i <= words.length - 2; i++) {
		middleName = middleName.trim() + " "+ words[i].trim() ;
	}
        
	System.out.println("Họ là: " + lastName);
	System.out.println("Tên đệm là: " + middleName.trim());
	System.out.println("Tên là: " + firstName);

    }
// Question 7:
	// Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
	// chuẩn hóa họ và tên của họ như sau:
	// a) Xóa dấu cách ở đầu và cuối của chuỗi người dùng nhập vào
	// VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
	// chuẩn hóa thành "nguyễn văn nam"
	// b) Viết hoa chữ cái mỗi từ của người dùng
    public static void Question7(){
        System.out.println("Nhập họ tên đầy đủ");
	String fullName = scanner.nextLine();
        fullName = fullName.trim();
	fullName = fullName.replaceAll("\\s+", " ");
        System.out.println("Sau khi xoa dau cach thua:\n"+fullName);
     
        String[] words = fullName.split(" ");
        fullName="";
        for(String word:words){
            word=word.substring(0, 1).toUpperCase()+word.substring(1);
            fullName=fullName+word+" ";
        }
        System.out.println("chuoi sau khi chuan hoa: "+fullName);
    }
    // Question 8:
	// In ra tất cả các group có chứa chữ "Java"
    public static void Question8() {
        String[] groups={"nguyen thi Java", "Java core","nguyen thi chinh", "ha thi linh","Java co ban"};
        for(String group: groups){
            if(group.contains("java")){
                System.out.println("in: "+group);
            } 
        }
    }
    // Question 9:
// In ra tất cả các group "Java"
    public static void Question9() {
	String[] groups = { "Java basic", "C#", "C++","Java", "Java core"};

	for (String group : groups) {
		if (group.equals("Java")) {
			System.out.println("in: "+group);
		}
	}
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
    }
    
}
