package org.example;

import org.example.db.ActorDB;
import org.example.db.CreditDB;
import org.example.db.MovieDB;
import org.example.model.Actor;
import org.example.model.Credit;
import org.example.model.Movie;
import org.example.util.Console;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MovieDBApp {

    public static void main(String[] args) {
        // initialize db(s)
        MovieDB movieDB = new MovieDB();

        System.out.println("Welcome to the Movie Database App!");
        displayMenu();

        ArrayList<Movie> movies = MovieDB.getMovies();
        String action = "";
        while (!action.equalsIgnoreCase("exit")) {
            action = Console.getString("Enter a command: ");
            System.out.println();

            switch (action) {
                case "list" -> displayAllMovies(movies);
                case "add" -> addMovie(movies);
                case "del", "delete" -> deleteMovie(movies);
                case "help", "menu" -> displayMenu();
                case "exit" -> System.out.println("Bye.\n");
                default -> System.out.println("Error! Command not valid.\n");
            }
        }


        System.out.println("Bye");
    }


    public static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all movies");
        System.out.println("add     - Add a movie");
        System.out.println("del     - Delete a movie");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAllMovies(ArrayList<Movie> movies) {
        System.out.println("MOVIE LIST");

        for (Movie m : movies) {
            System.out.println(m.getId()+", "+m.getTitle()+", "+m.getYear()+", "+m.getRating()+", "+m.getDirector());
        }
        System.out.println();
    }

    public static void addMovie(ArrayList<Movie> movies) {
        int id = Console.getInt("Enter movie id: ");
        String title = Console.getString("Enter title: ");
        int year = Console.getInt("Enter year: ");
        String rating = Console.getString("Enter rating: ");
        String director = Console.getString("Enter director: ");

        Movie m = new Movie(id, title, year, rating, director);
        movies.add(m);
        MovieDB.saveAll(movies);  // save product list to file

        System.out.println(title + " has been added.\n");
    }

    public static void deleteMovie(ArrayList<Movie> movies) {
        int id = Console.getInt("Enter movie id: ");

        for (Movie m : movies) {
            if (m.getId() == id) {
                movies.remove(m);
                MovieDB.saveAll(movies);  // save product list to file
                System.out.println(m.getTitle()
                        + " has been deleted.\n");
                return;
            }
        }

        System.out.println("No movie matches that id.\n");
    }
}