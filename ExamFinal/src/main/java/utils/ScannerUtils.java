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

    public static LocalDate inputDate(String errString) {
        while (true) {
            try {
                String dateString = scanner.nextLine();
                LocalDate localDate= LocalDate.parse(dateString);
                return localDate;

            } catch (Exception e) {
                printErrString(errString);
            }
        }
    }
    public static String inputEmail(String errString) {
        while (true) {
            String email = ScannerUtils.inputString(errString);
            if (email == null || !email.contains("@gmail.com")) {
                printErrString(errString);
                System.out.print("Mời bạn nhập lại email: ");
            } else {
                return email;
            }
        }
    }

}
