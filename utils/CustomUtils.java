package utils;

import java.util.Scanner;

public class CustomUtils {

    public static Scanner scanner = new Scanner(System.in);

    public static String GetString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int GetInt(String message) {
        System.out.println(message);
        int data = scanner.nextInt();
        scanner.nextLine();
        return data;
    }

    public static double GetDecimal(String message) {
        System.out.println(message);
        double data = scanner.nextDouble();
        scanner.nextLine();
        return data;
    }
}
