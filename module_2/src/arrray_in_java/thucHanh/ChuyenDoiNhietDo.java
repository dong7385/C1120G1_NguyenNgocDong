package arrray_in_java.thucHanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;
        System.out.println("Enter fahrenheit: ");
        fahrenheit = input.nextDouble();
        System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius(fahrenheit));

        System.out.println("Enter Celsius: ");
        celsius = input.nextDouble();
        System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit(celsius));
        do {
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }

}
