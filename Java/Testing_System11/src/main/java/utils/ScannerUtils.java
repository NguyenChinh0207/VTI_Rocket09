package utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
                formatter = formatter.withLocale(Locale.UK);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
                LocalDate date = LocalDate.parse(dateString, formatter);
                return date;

            } catch (Exception e) {
                printErrString(errString);
            }
        }
    }
}
