package com.backend.Ex1_Collection;

import com.entity.Student;

import java.util.*;

public class Ex1_Question {
    public void Question3(){

    }
    public void Question67() {
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "chinh");
        students.put(2, "Mai");
        students.put(3, "Lan");
        students.put(4, "Anh");
        //in key
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey());

        }
        System.out.println("cau b");
        //in value
        System.out.println(students.get(1));
        System.out.println(students.get(2));
        System.out.println(students.get(3));
        System.out.println(students.get(4));

        //get key and value
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " , " + "Name: " + entry.getValue());
        }
        //sort theo ten student
        System.out.println("cau c");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " , " + "Name: " + entry.getValue());
        }
        //chuyen sang set
        Set<Integer> set = students.keySet();
        for (Integer key : set) {
            System.out.println(key + " " + students.get(key));
        }
    }
}
