package com.backend.Ex3_Generic;

import com.entity.Generic.Employee;
import com.entity.Generic.Student;

public class GenericQuestion {
    public void Question1(){
        // tạo student có id là int
        Student<Integer> student1 = new Student<Integer>(1, "Chinh");
        // tạo student có id là float
        Student<Float> student2 = new Student<Float>(2.3f, "Mai");
        // tạo student có id là double
        Student<Double> student3 = new Student<Double>(39.9, "Lan");
        System.out.println("In student:");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

    }
    public void Question2(){
        Student<Float> student1 = new Student<Float>(2.3f, "Mai");
        print(student1);
        print(4);
        print(4.0);
    }
    public <T> void print(T a) {
        System.out.println(a);
    }
    public void Question4(){
        Integer[] arrayInt = { 1, 17, 2145 };
        Float[] arrayFloat = { 6.98f, 45.9f, 1.09f };
        Double[] arrayDouble = { 567.2, 87.8, 45.99 };
        System.out.println("in array:");
        printArray(arrayInt);
        printArray(arrayFloat);
        printArray(arrayDouble);

    }
    public <T> void printArray(T[] arrays) {
        for (T arr : arrays) {
            System.out.print(arr+" ");
        }
        System.out.println("");
    }
    public void Question5(){
//        // khởi tạo employee có salaries datatype là int
//        Integer[] salaryEmployee1 = { 1000, 1200, 1200 };
//        Employee<Integer> employee1 = new Employee<Integer>(1, "Đăng", salaryEmployee1);
//
//        System.out.println("Employee vừa khởi tạo: ");
//        print(employee1);
//        System.out.println("Tháng lương cuối cùng của employee 1: " + salaryEmployee1[salaryEmployee1.length - 1]);
//
//        // khởi tạo employee có salaries datatype là Float
//        Float[] salaryEmployee2 = { 1000f, 1200f, 1200f, 3000f };
//        Employee<Float> employee2 = new Employee<Float>(1, "Duy", salaryEmployee2);

//        System.out.println("Employee vừa khởi tạo: ");
//        print(employee2);
//        System.out.println("Tháng lương cuối cùng của employee 2: " + salaryEmployee2[salaryEmployee2.length - 1]);
//
//        // khởi tạo employee có salaries datatype là double
//        Double[] salaryEmployee3 = { 1000d, 1200d, 1200d, 6900d, 9600d, 12000d };
//        Employee<Double> employee3 = new Employee<Double>(1, "Thắng", salaryEmployee3);
//
//        System.out.println("Employee vừa khởi tạo: ");
//        print(employee3);
//        System.out.println("Tháng lương cuối cùng của employee1: " + salaryEmployee3[salaryEmployee3.length - 1]);

    }

}
