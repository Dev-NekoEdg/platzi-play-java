package utils;

import java.util.Scanner;

import contenido.Genre;

public class CustomUtils {

    public static Scanner scanner = new Scanner(System.in);

    public static String GetString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int GetInt(String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor ingrese un número válido.");
            scanner.next();
        }
        int data = scanner.nextInt();
        scanner.nextLine();
        return data;
    }

    public static double GetDecimal(String message) {
        System.out.println(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor ingrese un número válido.");
            scanner.next();
        }
        double data = scanner.nextDouble();
        scanner.nextLine();
        return data;
    }

    public static Genre GetGenre(String message) {
        while(true){
            System.out.println("Los géneros disponibles son:");
            for (Genre genre : Genre.values()) {
                System.out.println("- " + genre);
            }
            String genre = GetString(message);
            try 
            {
                Genre.valueOf(genre.toUpperCase());
                return Genre.valueOf(genre.toUpperCase());
            } 
            catch (IllegalArgumentException e) {
                System.out.println("Género no válido. Por favor, ingrese un género válido.");
            }

        }
    }
}
