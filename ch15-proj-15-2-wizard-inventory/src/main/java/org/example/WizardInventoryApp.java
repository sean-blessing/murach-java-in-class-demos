package org.example;

import java.util.ArrayList;
import java.util.List;

public class WizardInventoryApp {

    public static void main(String[] args) {
        System.out.println("The Wizard Inventory application\n");
        
        displayMenu();

        // all players start with these 3 items
        ArrayList<String> inventory = new ArrayList<>();
        inventory.add("wooden staff");
        inventory.add("wizard hat");
        inventory.add("cloth shoes");

        loop: while (true) {        
            String command = Console.getString("Command: ");
            
            switch (command) {
                case "show" -> {
                    show(inventory);
                }
                case "grab" -> {
                    grabItem(inventory);
                }
                case "edit" -> {
                    editItem(inventory);
                }
                case "drop" -> {
                    dropItem(inventory);
                }
                case "exit" -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Not a valid command. Please try again.\n");
                }
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("show - Show all items");
        System.out.println("grab - Grab an item");
        System.out.println("edit - Edit an item");
        System.out.println("drop - Drop an item");
        System.out.println("exit - Exit program");
        System.out.println();
    }

    private static void show(List<String> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            String item = inventory.get(i);
            int number = i + 1;
            System.out.println(number + ". " + item);
        }
        System.out.println();
    }

    private static void grabItem(List<String> inventory) {
        if (inventory.size() >= 4) {
            System.out.println("You can't carry any more items. " + 
                  "Drop something first.\n");
        } else {
            String item = Console.getString("Name: ");
            inventory.add(item);
            System.out.println(item + " was added.\n");
        }
    }

    private static void editItem(List<String> inventory) {
        int number = Console.getInt("Number: ");
        if (number < 1 || number > inventory.size()) {
            System.out.println("Invalid item number.\n");
        } else {
            String item = Console.getString("Updated name: ");
            inventory.set(number-1, item);
            System.out.println("Item number " + number + " was updated.\n");
        }
    }

    private static void dropItem(List<String> inventory) {
        int number = Console.getInt("Number: ");
        if (number < 1 || number > inventory.size()) {
            System.out.println("Invalid item number.\n");
        } else {
            String item = inventory.remove(number-1);
            System.out.println(item + " was dropped.\n");
        }
    }
}