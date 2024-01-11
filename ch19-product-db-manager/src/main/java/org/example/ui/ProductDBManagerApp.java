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
        System.out.println("ADD A PRODUCT");
        String code = Console.getString("Enter product code: ");
        String description = Console.getString("Enter product description: ");
        double price = Console.getDouble("Enter product price: ");

        Product p = new Product(code, description, price);

        if (ProductDB.add(p)) {
            System.out.println("Product added!");
        }
    }

    public static void deleteProduct() {
        System.out.println("DELETE A PRODUCT");
        boolean success = false;

        while (!success) {
            String code = Console.getString("Enter code for product to delete: ");
            Product p = ProductDB.get(code);
            if (p == null) {
                System.out.println("No product for code: "+code+". Please try again.");
            }
            else {
                if (ProductDB.delete(p)) {
                    success = true;
                    System.out.println("Product successfully deleted!");
                }
            }
        }

    }
}