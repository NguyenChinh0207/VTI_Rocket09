/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author May tinh Duy Toi
 */

public class QLCB {
    private List<CanBo> canBos;
    private Scanner scanner;
    
    public QLCB() {
        canBos=new ArrayList<>();
        scanner=new Scanner(System.in);
    }
    
    public void addCanBo(){
        System.out.println("Ban muon add bao nhieu can bo:");
        int n=scanner.nextInt();
        
            for(int i=0;i<n;i++){
                
            System.out.println("Ban muon nhap vao (1.Cong nhan, 2.Ky Su, 3.NhanVien)");
            int choose=scanner.nextInt();
            switch(choose){
                case 1:
                    canBos.add(new CongNhan());
                    break;
                case 2:
                    canBos.add(new KySu());
                    break;
                case 3:
                    canBos.add(new NhanVien());
                    break;
                default:
                    System.out.println("Nhập sai tieu chuan !");
                    i--;
                    break;
            }
                System.out.println("Nhap thanh cong can bo thu"+(i+1));
        
        }
    }
    public void findByName(){
	System.out.println("Nhập họ tên cần tìm: ");
	String hoTen = scanner.nextLine();
	for (CanBo canBo : canBos) {
		if (hoTen.equals(canBo.getHoTen())) {
			canBo.toString();
		}
	}
    }
    public void printListCanBo(){
        for(CanBo canBo: canBos){
            System.out.println(canBo);
        }
        System.out.println("--------");
    }
  
    public void deleteCanBo(){      
	System.out.println("Nhập họ tên cần xóa: ");
	String hoTen = scanner.nextLine();

	canBos.removeIf(cb -> hoTen.equals(cb.getHoTen()));
    }
}
