package com.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class scannerUtils {
    public static Scanner scanner=new Scanner(System.in);
    public static int inputInt(String errMessage){
        while (true) {
            try {
                int input=Integer.parseInt(scanner.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println(errMessage);
            }
        }

    }
    public static float inputFloat(String errMessage){
        while (true) {
            try {
                float input=Float.parseFloat(scanner.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println(errMessage);
            }
        }

    }
    public static double inputDouble(String errMessage){
        while (true) {
            try {
                Double input=Double.parseDouble(scanner.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println(errMessage);
            }
        }

    }
    public static String  inputString(String errMessage){
        while (true) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println(errMessage);
            }
        }


    }
    public static LocalDate inputDate(String errorMessage){
        while(true){
            try{
                String date=scanner.nextLine();
                LocalDate localDate = LocalDate.parse(date);
                return localDate;
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
    }
    public static int inputAge() throws InvalidAgeInputingException {
        while (true) {
                int age=inputInt("Wrong inputing! Please input an age as int, input again");
                if (age <= 0) {
                    throw new InvalidAgeInputingException("Wrong inputing! The age must be greater than 0, please input again.");
                } else {
                    return age;
                }

        }
    }
}
