package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductsWriterDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to the products writer!");

        String filename = "products.txt";

        PrintWriter out = null;
        try {
            out = new PrintWriter(
                  new BufferedWriter(
                  new FileWriter(filename)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        out.println("java\tMurach's Java Programming\t57.5");

        out.close();

        System.out.println("Bye");
    }
}