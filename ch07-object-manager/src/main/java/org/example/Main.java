package org.example;

import org.example.model.Product;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Product Manager!");
        Product p1 = new Product();
        p1.setCode("java");
        p1.setDescription("Murach's Java Programming");
        p1.setPrice(57.5);
        System.out.println(p1.toString());

        Product p2 = new Product(".net", "Murach's .Net", 59.5);
        System.out.println(p2);

        System.out.println("Bye!");
    }
}