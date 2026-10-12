
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("     TEMPERATURE CONVERTER");
        System.out.println("================================");

        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");

        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        System.out.print("Enter temperature: ");
        double temperature = sc.nextDouble();

        if (choice == 1) {

            double fahrenheit = (temperature * 9.0 / 5.0) + 32;

            System.out.println("Temperature in Celsius: " + temperature);
            System.out.println("Temperature in Fahrenheit: " + fahrenheit);

        } else if (choice == 2) {

            double celsius = (temperature - 32) * 5.0 / 9.0;

            System.out.println("Temperature in Fahrenheit: " + temperature);
            System.out.println("Temperature in Celsius: " + celsius);

        } else {

            System.out.println("Invalid choice! Please enter 1 or 2.");

        }

        System.out.println("================================");
        System.out.println("Thank you for using the program!");

        sc.close();
    }
}
