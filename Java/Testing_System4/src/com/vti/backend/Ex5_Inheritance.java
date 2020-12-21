/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.backend;

import com.vti.entity.QLCB;
import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */
public class Ex5_Inheritance {
    public void Question2(){
        Scanner scanner=new Scanner(System.in);
        QLCB qlcb=new QLCB();
        
        System.out.println("Nhap chuc nang so:\n"+"1.Them moi can bo\n2.Tim kiem theo ho ten\n"+"3.Hien thi thong tin ds can bo\n"+"4.Nhap ten can bo va xoa can bo do."+"\n5.Thoat chuong trinh");
        while(true){
            System.out.print("Moi ban chon chuc nang: ");
        int choose=scanner.nextInt();
        switch(choose){
            case 1:
               qlcb.addCanBo();
               break;
            case 2:
                qlcb.findByName();
                break;
            case 3:
                qlcb.printListCanBo();
                break;
            case 4:
                qlcb.deleteCanBo();
                break;
            case 5:
                return;//break thi thoat khoi switch case thoi, dung return de thoat khoi ca
            default:
                System.out.println("Chi duoc nhap tu 1->5");
                break;
        }
        }
        
                
                    
    }
}
