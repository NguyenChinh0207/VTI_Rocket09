package com.backend;

import com.entity.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2_Exception {
    //Question1
    public void Question1(){
        try{
            float result=divide(7,0);
            System.out.println(result);
        }
        catch(Exception e){
            System.out.println("cannot divide 0");
        }

    }
    private static float divide(int a, int b) {
        return a/b;
    }
    //Question2
    public void Question2(){
        try{
            float result=divide(7,0);
            System.out.println(result);
        }
        catch(Exception e){
            System.out.println("cannot divide 0");
        }
        finally {
            System.out.println("divide completed!");
        }
    }
    //Question3
    public void Question3(){
       try{
           int[] numbers={1,2,3};
           System.out.println(numbers[10]);
       }
        catch(Exception e){
           e.printStackTrace();
        }
    }
    //Question4
    public Department[] departments;
    public void Question4(){
        departments=new Department[3];
        Department department1=new Department(1,"Sale");
        Department department2=new Department(2,"PM");
        Department department3=new Department(3,"Marketing");
        departments[0]=department1;
        departments[1]=department2;
        departments[2]=department3;
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap index:");
        n=scanner.nextInt();
        try{

            getIndex(n);
        }
        catch(Exception e){
            System.out.println("Cannot find department");
        }

    }
    public void getIndex(int index){
        System.out.println("Thong tin department thu "+index+": "+departments[index]);
    }

    //Question 5-6
    public void Question56(){
        System.out.println("Nhap vao 1 so:");
        System.out.println("Số vừa nhập là :"+inputAge());
    }

    public static int inputAge() {

        while (true) {
            try {
                Scanner scanner=new Scanner(System.in);
                int age=Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
                } else {
                    return age;
                }

            } catch (Exception e) {
                System.out.println("wrong inputing! Please input an age as int, input again.");
            }
        }
    }

    //Question 7
    public void Question7(){
        System.out.println("Please age: ");
        int age = scannerUtils.inputInt("wrong inputing! Please input an age as int, input again. ");
        System.out.println("Your age: " + age);

        System.out.println("Please id: ");
        int id = scannerUtils.inputInt("wrong inputing! Please input an id as int, input again. ");
        System.out.println("Your id: " + id);

    }
    //Question 8
    public void Question8(){
        System.out.println("Please your point avg: ");
        float point = scannerUtils.inputFloat("wrong inputing! Please input a point avg as float, input again. ");
        System.out.println("Your point avg: " + point);

        System.out.println("Please Yourname : ");
        String name = scannerUtils.inputString("wrong inputing! Please input is not empty, input again. ");
        System.out.println("Your Name: " + name);

    }

    //Question 9
    public void Question9(){
        System.out.println("--------  Department ------- ");
        Department department = new Department();
        System.out.println(department);

        System.out.println("--------  Position --------");
        Position position = new Position();
        System.out.println(position);

    }
    //Question 10
    public void Question10() throws InvalidAgeInputingException {
        System.out.println("Nhâp thông tin Group:");
        Group group=new Group();
        System.out.println(group.toString());
    }
    //Question 11+12
    public void Question1112()  {
        System.out.println("Nhập thông tin tuổi của account");
        try{
            Account account=new Account();
            System.out.println(account.toString());
        }
        catch(InvalidAgeInputingException i){
            System.out.println(i.getMessage());
        }
    }
}
