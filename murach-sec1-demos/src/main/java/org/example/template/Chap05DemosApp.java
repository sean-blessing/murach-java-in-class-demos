package org.example.template;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Chap05DemosApp {
    public static void main(String[] args) {

        // 1 - Static methods
        displayWelcome();
        // 2 - Exceptions - slide 14
        Scanner sc = new Scanner(System.in);
        // prompt for a number but get a non numeric from user
        System.out.print("Please enter a whole number: ");

        // 3 - Try-catch - slide 17
        int aNumber = 0;
        try {
            aNumber = sc.nextInt();
            System.out.println("aNumber = " + aNumber);
        }
        catch (InputMismatchException ime) {
            System.out.println("Error! Entry must be a whole number.");
        }

        // 4 - Data validation - slide 23
        // Get a double (decimal) value
        System.out.print("Enter a decimal value: ");
        double aDouble = 0.0;
        if (sc.hasNextDouble()) {
            aDouble = sc.nextDouble();
        }
        else {
            System.out.println("Error - value much be a decimal.");
        }

        System.out.println("aDouble = "+aDouble);

        displayGoodbye("Bye!");
    }

    private static void displayGoodbye(String x) {
        System.out.println(x);
    }

    public static void displayWelcome() {
        System.out.println("Chapter 5 Demos App");
    }
}