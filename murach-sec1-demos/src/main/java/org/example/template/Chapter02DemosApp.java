package org.example.template;

import java.util.Scanner;

public class Chapter02DemosApp {
    public static void main(String[] args) {
        System.out.println("Chapter 2 Demos App");

        // 0 - Maven discussion, POM file

        // 1 - Create a new project

        // 2 - Create a new class

        // 3 - Declare String, int variables
        String firstName = "Bob";
        String lastName = "Marley";

        int nbr1 = 11;
        int nbr2 = 20;

        String nullString = null;

        int nbr3 = 0;

        System.out.println("Hello there!");
        System.out.println(firstName+ " " + lastName);

        System.out.println(nullString);
        System.out.println(nbr3);

        // 4 - Define some comments
        /*
        This is a multi line comment
         */

        /**
         * This is a JavaDoc comment
         */

        // 5 - Escape characters

        String title = "Harry Potter and the Sorcerer's Stong\n by J.K. Rowling";
        System.out.println(title);

        // 6 - Discuss packages, import statements
        //     hold for later

        // 7 - java.lang by default, all others need to be imported

        // 8 - if statement
        Scanner sc = new Scanner(System.in);

        System.out.print("Give me a number: ");
        int aNumber = sc.nextInt();

        // is the number greater than 20?
        if (aNumber > 20) {
            System.out.println(aNumber + " is greater than 20.");
        }
        else if (aNumber > 10) {
            System.out.println(aNumber + " is greater than 10.");
        }
        else if (aNumber > 0) {
            System.out.println(aNumber + " is greater than 0.");
        }
        else {
            System.out.println(aNumber + " is negative.");
        }

        // 9 - while statement
        // continue statement

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Do you want to continue? ");
            choice = sc.next();
        }

        // 10 - Exceptions

        System.out.println("Bye!");
    }
}