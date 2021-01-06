package com.backend.Ex2_Comparing;


import com.entity.Student_Comparing;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.*;
import java.util.Collections;

public class ComparingQuestion {
    private List<Student_Comparing> studentss;
    private Scanner scanner;

    public ComparingQuestion() {
        scanner = new Scanner(System.in);
        studentss = new ArrayList<>();
        createStudent();
    }

    public void createStudent() {
        studentss.add(new Student_Comparing(1,"Hoa",  LocalDate.parse("2000-05-01"), 8));
        studentss.add(new Student_Comparing(2,"Chinh",  LocalDate.parse("2000-11-11"), 9));
        studentss.add(new Student_Comparing(3,"Chinh",  LocalDate.parse("2000-11-11"), 5));
        studentss.add(new Student_Comparing(4,"Chinh",  LocalDate.parse("2000-02-22"), 7));
        studentss.add(new Student_Comparing(5,"Long",  LocalDate.parse("2000-11-24"), 10));
    }

    public void printStudent() {
        for (Student_Comparing student : studentss) {
            System.out.println(student);
        }
    }
    public void question1_2() {
        System.out.println("Students truoc khi sắp xếp: ");
        printStudent();
        Collections.sort(studentss);
        System.out.println("Students sau khi sắp xếp: ");
        printStudent();
    }


}
