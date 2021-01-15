package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    private static void printErrString(String errString) {
        System.out.println(errString);
    }

    public static String inputString(String errString) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                printErrString(errString);
            }
        }
    }

    public static int inputInt(String errString) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (Exception e) {
                printErrString(errString);
            }

        }
    }

    public static String inputPassWord(String errString) {
        while (true) {
            String password = ScannerUtils.inputString(errString);
            if (password.length() < 6 || password.length() > 12) {
                printErrString(errString);
                continue;
            }
            int check = 0;
            for (int i = 0; i < password.length(); i++) {
                char character = password.charAt(i);
                if (Character.isUpperCase(character) == true) {
                    check = 1;
                    break;
                }
            }
            if(check==1){
                return password;
            }
            else
            {
                printErrString(errString);
                System.out.print("Please input password: ");
            }
        }

    }

    public static String inputEmail(String errString) {
        while (true) {
            String email = ScannerUtils.inputString(errString);
            if (email == null || !email.contains("@vti.com.vn")) {
                printErrString(errString);
                System.out.print("Please input email: ");
            } else {
                return email;
            }
        }
    }

    public static int inputID(String errString) {
        while (true) {
            int id = ScannerUtils.inputInt(errString);
            if (id <= 0) {
                printErrString(errString);
                System.out.print("Please input id: ");
            } else {
                return id;
            }
        }
    }


}
