/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend;

import com.entity.abstraction.News;
import com.entity.abstraction.ThiSinh;
import com.entity.abstraction.TuyenSinh;
import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class Ex1_Abstract {
    public void Question1(){
        News news = new News();
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        do{
            loadMenu();
            choose = scanner.nextInt();

            switch (choose){
                case 1:
                    news.insertNews();
                    break;
                case 2:
                    news.display();
                    break;
                case 3:
                    news.calculate();
                    news.display();
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
            }

        }while(choose != 4);
    
    }
    public static void loadMenu(){
        System.out.println("---------------");
        System.out.println("1 - Insert news");
        System.out.println("2 - View list news");
        System.out.println("3 - Average rate");
        System.out.println("4 - Exit");
        System.out.println("---------------");
    }
    
    //Question2
    public void Question2(){
        TuyenSinh tuyenSinh = new TuyenSinh();
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        do{
            loadMenu2();
            choose = scanner.nextInt();

            switch (choose){
                case 1:
                    tuyenSinh.addThiSinh();
                    break;
                case 2:
                    tuyenSinh.viewThiSinh();
                    break;
                case 3:
                  
                    tuyenSinh.searchThiSinh();
                    break;
                case 4:
                    System.out.println("Thoat");
                    break;
            }

        }while(choose != 4);
    
    }
    public static void loadMenu2(){
        System.out.println("---------------");
        System.out.println("1 - Them moi thi sinh");
        System.out.println("2 - Hien thi thong tin thi sinh và khoi thi");
        System.out.println("3 - Tim kiem theo sbd");
        System.out.println("4 - Exit");
        System.out.println("---------------");
    }
}
