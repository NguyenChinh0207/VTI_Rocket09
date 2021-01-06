package com.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static void printErrString(String errString){
        System.out.println(errString);
    }

    public static String inputString(Scanner scanner, String errString){
        while(true){
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()){
                return input;
            } else {
                printErrString(errString);
            }
        }
    }
}
