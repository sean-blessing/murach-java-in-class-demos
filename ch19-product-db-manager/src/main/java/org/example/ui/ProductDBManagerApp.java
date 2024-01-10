package org.example.ui;

import org.example.db.ProductDB;
import org.example.model.Product;
import org.example.util.Console;

import java.util.ArrayList;
import java.util.List;

public class ProductDBManagerApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Product Manager\n");
        String action = "";

        while (!action.equalsIgnoreCase("exit")) {
            displayMenu();
            action = Console.getString("Enter a command: ");
            System.out.println();

            switch (action) {
                case "list" -> displayAll();
                case "get" -> get();
                case "add" -> addProduct();
                case "del", "delete" -> deleteProduct();
                case "help", "menu" -> displayMenu();
                case "exit" -> System.out.println("Bye.\n");
                default -> System.out.println("Error! Command not valid.\n");
            }
        }
        System.out.println("Bye");
    }

    public static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all products");
        System.out.println("get     - Get a product");
        System.out.println("add     - Add a product");
        System.out.println("del     - Delete a product");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAll() {
        System.out.println("PRODUCT LIST");
        List<Product> products = ProductDB.getAll();
        for (Product p: products) {
            System.out.println(p);
        }
        System.out.println();
    }

    public static void get() {
        System.out.println("GET A PRODUCT");
        String code = Console.getString("Enter product code: ");
        Product product = ProductDB.get(code);
        if (product != null) {
            System.out.println(product);
        }
        else {
            System.err.println("No product found for code: "+code);
        }
        System.out.println();
    }

    public static void addProduct() {
        System.out.println("Not Yet Implemented.");
    }

    public static void deleteProduct() {
        System.out.println("Not Yet Implemented.");
    }
}