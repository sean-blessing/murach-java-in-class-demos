package org.example.ui;

import org.example.model.Product;

import java.util.*;

public class Chapter15DemoApp {
    public static void main(String[] args) {
        System.out.println("Chapter 15 Demos App!");

        // 1 - The Collections Framework - p. 501
        // Review Framework diagram

        // 2 - Generics to create an ArrayList that holds any type - why??
        //      I was wrong!! But you still shouldn't do this!

        var numbers = new ArrayList();
        numbers.add(1);
        numbers.add("two");

        int num1 = (int) numbers.get(0);
        String num2 = (String) numbers.get(1);

        System.out.println(num1);
        System.out.println(num2);

        // 3 - An ArrayList that holds only one type
        //      Isn't that better? :)
        var nbrs = new ArrayList<Integer>();
        nbrs.add(1);
        //nbrs.add("two"); // checks type – doesn't compile
        int nbr1 = nbrs.get(0); // no cast necessary

        // 4 - LinkedList - p. 505
        //      Just discuss
        // - A linked list doesn’t use an array to store its elements.
        //   Instead, each element in the list contains pointers that
        //   are used to refer to adjacent elements.
        // - Same List interface type as ArrayList so can use the same methods.
        // - More efficient to insert an element into the middle of a LL.
        // - Accessing elements is less efficient in a LL

        // 5 - Collections class methods - p. 511
        ArrayList<String> letters = new ArrayList<>();
        letters.add("z");
        letters.add("g");
        letters.add("a");
        letters.add("p");

        System.out.println("letters arraylist: "+letters);

        Collections.sort(letters);
        System.out.println("letters arraylist sorted: "+letters);

        Collections.sort(letters, Collections.reverseOrder());
        System.out.println("letters arraylist reversed: "+letters);

        // 6 - Comparable interface demo - p. 513
        //      Sorting a reference type doesn't work out of the box

        List<Product> products = new ArrayList<>();
        Product p1 = new Product("java", "Murach's Java", 59.5);
        products.add(p1);
        Product p2 = new Product("andr", "Murach's Android", 62.5);
        products.add(p2);
        Product p3 = new Product("mysql", "Murach's MySQL", 57.50);
        products.add(p3);

        System.out.println("List of products: ");
        for(Product p: products) {
            System.out.println(p);
        }
        Collections.sort(products);
        System.out.println("List of products - sorted: ");
        for(Product p: products) {
            System.out.println(p);
        }

        // 7 HashMaps - p. 523
        // TreeMaps' keys are sorted, so HashMaps typically more efficient
        Map<String, String> midwestStates = new HashMap<>();
        midwestStates.put("OH", "Ohio");
        midwestStates.put("IL", "Illinois");
        midwestStates.put("MO", "Missouri");
        midwestStates.put("IN", "Indiana");
        midwestStates.put("MI", "Michigan");

        // get a single value:
        System.out.println("OH: "+midwestStates.get("OH"));

        // I found a good use of var!
        for (var state: midwestStates.entrySet()) {
            System.out.println("Abbrev: "+state.getKey()+" - State: "+state.getValue());
        }

        System.out.println("Replace MO value...");
        midwestStates.put("MO", "Missery");
        for (var state: midwestStates.entrySet()) {
            System.out.println("Abbrev: "+state.getKey()+" - State: "+state.getValue());
        }


        System.out.println("bye");
    }
}
