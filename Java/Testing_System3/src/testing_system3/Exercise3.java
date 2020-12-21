/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_system3;

/**
 *
 * @author May tinh Duy Toi
 */
public class Exercise3 {

    /**
     * @param args the command line arguments
     */
//  Q1:  Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//float có 2 số sau dấu thập phân)
    public static void Question1(){
        Integer salary = 5000;
	System.out.printf("%.2f", (float) salary);
        System.out.println("\n");
    }
//    Question 2:
//Khai báo 1 String có value = "1234567"
//Hãy convert String đó ra số int
    public static void Question2(){
        String s="1234567";
        int num=Integer.parseInt(s);
        System.out.println(num);
       
    }
//   Question 3:
//Khởi tạo 1 số Integer có value là chữ "1234567"
//Sau đó convert số trên thành datatype int
    public static void Question3(){
        Integer num = 1234567;
        int number=num.intValue();
        System.out.println(number);
    }
    
    
    public static void main(String[] args) {
        Question1();
        Question2();
        Question3();
    }
    
}
