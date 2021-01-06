package com.backend.Ex1_Collection;

import com.entity.Student;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex1_Question2 {
    public void Question2(){
        //cau a
        System.out.println("Student đến phỏng vấn từ sớm nhất đến muộn nhất: ");
        studentEarlyLate();
        //cau b
        System.out.println("Student đến phỏng vấn từ muộn nhất đến sớm nhất: ");
        studentLateEarly();
    }
    public void studentEarlyLate() {
        Stack<Student> students = new Stack<>();
        students.push(new Student("Nguyễn Văn A"));
        students.push(new Student("Trần Văn Nam"));
        students.push(new Student("Nguyễn Văn Huyên"));
        students.push(new Student("Nguyễn Văn Nam"));

        // lay ra
        System.out.println(students.pop());
        System.out.println(students.pop());
        System.out.println(students.pop());
        System.out.println(students.pop());
    }

    public void studentLateEarly() {
        Queue<Student> students = new LinkedList<>() ;
        students.add(new Student("Nguyễn Văn A"));
        students.add(new Student("Trần Văn Nam"));
        students.add(new Student("Nguyễn Văn Huyên"));
        students.add(new Student("Nguyễn Văn Nam"));
        //lay ra
        System.out.println(students.poll());
        System.out.println(students.poll());
        System.out.println(students.poll());
        System.out.println(students.poll());

    }

}
