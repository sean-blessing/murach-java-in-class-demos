package org.example.template;

import org.example.model.Product;

import java.io.*;
import java.util.ArrayList;

public class Chapter09DemosApp {
    private static final String COLUMN_SEP = "\t";

    public static void main(String[] args) {
        System.out.println("Chapter 9 Demos App");

        // Use book_apps ch09_ProductManager?

        // 1 - import I/O classes - p. 277

        // 2 - Define a file and write data

        String productFileName = "products.txt";
        ArrayList<Product> products = new ArrayList<>();

        // write data to products file - no try-with-resources
        try {
            PrintWriter out = new PrintWriter(
                              new BufferedWriter(
                              new FileWriter(productFileName)));
            Product javaBook = new Product("java", "Murach's Java Programming", 57.5);
            products.add(javaBook);
            out.println(javaBook.getCode()+COLUMN_SEP+javaBook.getDescription()+COLUMN_SEP+javaBook.getPrice());
            out.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read data from products file
        try {
            BufferedReader in = new BufferedReader(
                                new FileReader(productFileName));
            String line = in.readLine();
            System.out.println("line from product file: "+line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // write another record - try with resources - p. 279
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(productFileName, true)))) {
            Product netBook = new Product(".net", "Murach's .Net Programming", 59.5);
            products.add(netBook);
            out.println(netBook.getCode()+COLUMN_SEP+netBook.getDescription()+COLUMN_SEP+netBook.getPrice());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        products.clear();
        // read all records and print to console
        try (BufferedReader in = new BufferedReader(
                                 new FileReader(productFileName))) {
            String line = in.readLine();
            while (line != null) {
                String columns[] = line.split(COLUMN_SEP);
                String code = columns[0];
                String desc = columns[1];
                String priceStr = columns[2];
                double price = Double.parseDouble(priceStr);
                Product p = new Product(code, desc, price);
                products.add(p);
                line = in.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final list of products: "+products);
        System.out.println("Bye!");
    }
}