/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend;
import com.entity.polymorphism.Question2.Student;
import java.util.Scanner;
/**
 *
 * @author May tinh Duy Toi
 */
public class Ex2_Polymorphism_question2 {
    private Scanner scanner =new Scanner(System.in);
    public void Question2(){
        EX2_question2_StudentManager studentManager=new EX2_question2_StudentManager();
        int choose = 0;
        do{
            loadMenu();
            choose = scanner.nextInt();

            switch (choose){
                case 1:
                    studentManager.createStudent();
                    break;
                case 2:
                    studentManager.showInfoStudent();
                    break;
                case 3:
                    studentManager.isHocBong();
                    break;
               
            }

        }while(choose != 3);
    }
    public static void loadMenu(){
        System.out.println("---------------");
        System.out.println("1 - Nhap thong tin student");
        System.out.println("2 - Show thong tin student");
        System.out.println("3 - Nhap vao ten 1 sv, xét học bong cua sinh vien ay");      
        System.out.println("---------------");
    }
}
