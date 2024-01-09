package org.example.template;

import java.text.NumberFormat;

public class Chap03DemosApp {
    public static void main(String[] args) {
        System.out.println("Chapter 3 Demos App");

        // 1 - The primitive types
        double price1 = 19.99;

        // 2 - Type inference (JDK10) - slide 10
        var salesTax = .065;

        double total = price1 * (1+salesTax);
        System.out.println("total = "+total);

        // 3 - Compound Assignment Operators - slide 15
        int count = 0;
        count += 1;

        // 4 - Arithmetic Unary Operators - slide 18
        count++;

        System.out.println(count);

        // 5 - Casting - implicit vs explicit - slide 24

        // 6 - Math class - slide 28
        //      round, pow, sqrt, max, min, random
        // round
        double roundedTotal = Math.round(total);
        System.out.println("roundedTotal = "+roundedTotal);
        roundedTotal = (double)Math.round(total*100) / 100;
        System.out.println("new roundedTotal = "+roundedTotal);

        // 7 - NumberFormat class
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println("formatted roundedTotal = "+currencyFormat.format(total));

        // 8 - Digits
        double interestRate = .075482;
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(3);
        System.out.println("interest rate = "+percentFormat.format(interestRate));

        // 9 - printf - slide 42
        String name = "Joel";
        int age = 39;
        System.out.printf("%s is %d years old.%nYoung man!", name, age);

        System.out.println("Bye!");
    }
}