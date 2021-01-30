package utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    private static void printErrString(String errString){
        System.out.println(errString);
    }

    public static String inputString(String errString){
        while(true){
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()){
                return input;
            } else {
                printErrString(errString);
            }
        }
    }
    public static int inputInt(String errString){
        while(true){
            try {
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (Exception e) {
                printErrString(errString);
            }

        }
    }
}
