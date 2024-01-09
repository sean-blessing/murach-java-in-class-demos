package org.example;

import org.example.model.*;

import java.util.ArrayList;

public class Chapter10DemoApp {
    public static void main(String[] args) {
        System.out.println("Chapter 10 Demos App");

        // 1 - The scenario - Product, Book, Software - page 315

        // 2 - Inherited methods from java.lang.Object - page 317
        //     demonstrate each, using String (later talk about clone)
        Product p1 = new Product("java", "Murach's Java Programming", 59.5);

        System.out.println(p1.toString());
        System.out.println(p1.superToString());
        System.out.println("class is "+p1.getClass().getSimpleName());

        Product p2 = new Product("java", "Murach's Java Programming", 59.5);

        System.out.println("Are these products equal? "+p1.equals(p2));


        // 3 - Access modifiers (review) and overriding methods - page 319

        // 4 - Creating subclasses - page 321
        //     Use Product class in model package
        //     Create Software and Product sublasses
        Book b1 = new Book("sql", "Murach's SQL", 49.5, "Joel Murach");
        System.out.println(b1.toString());

        // 5 - Create instances of each - page 323
        //     Elaborate examples start on page 327

        // 6 - instanceof change - JDK 16 - p. 337
        // Is b1 an instance of Product?
        System.out.println("b1 instanceof Product? "+(b1 instanceof Product));

        // 7 - equals method - p. 339


        // 8 - abstract class - p. 343
        // Before abstract keyword added to Product
        Product p3 = new Product ("test", "Test Product", 0);
        System.out.println(p3);

        // 9 - final class - p. 345

        // 10 - sealed class - p. 347

        // 11 - Records JDK 16 - p. 349
        Movie m = new Movie(1, "Test title", 2000, "PG", "Dir");
        System.out.println(m.id());
        Movie m1 = new Movie(2, "Another movie", 2020, "G", "director");

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m);
        movies.add(m1);

        // 12 - Inheritance vs composition - p. 353

        System.out.println("Bye!");
    }
}