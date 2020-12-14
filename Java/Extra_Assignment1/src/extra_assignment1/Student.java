/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra_assignment1;

import java.time.LocalDate;

/**
 *
 * @author May tinh Duy Toi
 */
public class Student {
    int id;
    String hoTen;
    LocalDate ngaySinh;
    String queQuan;
    Gender gioitinh;
    HeSinhVien heSinhVien;
    int namNhapHoc;
    int[] diems;
    LopHoc[] lopHocs;
    
    void goToSchool(){
        System.out.println("I am going to school");
    }
    void dangKiLopHoc(){
        System.out.println("Dang ki lop hoc");
    }
}
