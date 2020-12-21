/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.backend;

import com.vti.entity.Student;

/**
 *
 * @author May tinh Duy Toi
 */
public class Exercise4 {
    
    public void Question1(){
        Student student=new Student("Nguyễn Thị Chinh","Hà Nội");        
        student.setPoint((float) 7.8);
        student.addPoint((float) 1.2);
        student.studentPrinter(student);
   
    }
}
