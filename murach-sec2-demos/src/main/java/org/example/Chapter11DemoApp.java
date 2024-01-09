package org.example;

import org.example.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Chapter11DemoApp {
    public static void main(String[] args) {
        System.out.println("Chapter 10 Demos App");

        // 1 - Interfaces - printable - p. 361 thru 371
        //      Define printable interface
        //      Modify Product to implement printable
        //      Call Product's print method
        //      Create a few products, put in a list, then pass to method accepting Printable
        Book b1 = new Book("java", "Murach's Java", 59.50, "Joel Murach");
        Book b2 = new Book(".net", "Murach's .Net", 57.50, "Deb Murach");
        Book b3 = new Book("andr", "Murach's Android Programming", 58.00, "Sam Murach");
        Software s1 = new Software("mysql", "MySQL Server", 0.0, "18");
        Software s2 = new Software("turb", "Turbo Tax", 69.99, "2024");

        ArrayList<Printable> printables = new ArrayList<>();
        printables.add(b1);
        printables.add(b2);
        printables.add(b3);
        printables.add(s1);
        printables.add(s2);

        printStuff(printables);

        // 2 - Enumerations - p. 375
        //     demonstrate each, using String (later talk about clone)
        ShippingType shipType = ShippingType.UPS_NEXT_DAY;

        System.out.println("Cost for shipping = "+getShippingAmount(shipType));


        // 3 - Libraries - p. 384
        //     Discussion only - scenario - Console in a library

        // 4 - Javadoc - p. 391
        //     discussion only

        System.out.println("Bye!");
    }

    private static void printStuff(ArrayList<Printable> products) {
        for (Printable p: products) {
            p.print();
        }
    }

    private static double getShippingAmount(ShippingType shipType) {
        double shipAmount = switch (shipType){
            case UPS_GROUND -> 2.99;
            case UPS_SECOND_DAY -> 5.99;
            case UPS_NEXT_DAY -> 10.99;
            default -> 0.0;
        };
        return shipAmount;
    }
}