package org.example.template;

import java.util.Scanner;

public class Chap04DemosApp {
    public static void main(String[] args) {
        System.out.println("Chapter 4 Demos App");

        // 1 - The logical operators - slide 7
        //      &&, ||, and !


        // 2 - If/else statement - slide 10

        // 3 - Switch - old - slide 17
        String description;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product id: ");
        int id = sc.nextInt();

//        switch (id) {
//            case 1:
//                description = "Hammer";
//                break;
//            case 2:
//                description = "Box of Nails";
//                break;
//            default:
//                description = "Product not found";
//                break;
//        }
//
//        System.out.println("Description = "+description);

        String dayCode = "Wed";
        String day = "";
//        switch (dayCode) {
//            case "Mon":
//            case "Tue":
//            case "Wed":
//            case "Thu":
//            case "Fri":
//                day = "weekday";
//                break;
//            case "Sat":
//            case "Sun":
//                day = "weekend";
//                break;
//        }

        System.out.println("day is "+ day);

        // 4 - Switch - new (JDK 12) - slide 20

        switch (id) {
            case 1 -> description = "Screwdriver";
            case 2 -> description = "Box of Screws";
            default -> description = "Product not found";
        }

        System.out.println("description = "+description);

        switch (dayCode) {
            case "Mon", "Tue", "Wed", "Thu", "Fri" -> day = "weekday";
            case "Sat", "Sun" -> day = "weekend";
            default -> day = "";
        }

        System.out.println("day = "+day);
        String status = "";
        switch (dayCode) {
            case "Sun", "Mon" -> {
                status = "Closed";
            }
            default -> {
                int hour = java.time.LocalTime.now().getHour();
                if (hour >= 9 && hour < 17)
                    status = "Open";
                else
                    status = "Closed";
            }
        }
        System.out.println("Status = "+status);

        String productDescription = switch(id) {
            case 1 -> "Nail Gun";
            case 2 -> "Ladder";
            default -> "Not found";
        };

        System.out.println("Product description = "+productDescription);

        // 5 - Switch exp in assignment - slide 25

        // 6 - Switch w/ yield - slide 27

        // 7 - While loop - slide 30

        // 8 - Do-while loop - slide 33

        // 9 - For loop - slide 36

        // print 1 to 10
        for (int i = 0; i <= 10; i++) {
            System.out.println("i = "+i);
        }

        System.out.println("Bye!");
    }
}