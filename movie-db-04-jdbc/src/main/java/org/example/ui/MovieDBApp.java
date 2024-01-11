package org.example.ui;

import org.example.db.MovieDB;
import org.example.model.Movie;
import org.example.util.Console;

import java.util.List;

public class MovieDBApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Movie DB App!\n");
        String action = "";

        while (!action.equalsIgnoreCase("exit")) {
            displayMenu();
            action = Console.getString("Enter a command: ");
            System.out.println();

            switch (action) {
                case "listM", "listm" -> displayAllMovies();
                case "getM" -> getMovie();
                case "addM" -> addMovie();
                case "delM", "deleteM" -> deleteMovie();
                case "help", "menu" -> displayMenu();
                case "exit" -> System.out.println("Bye.\n");
                default -> System.out.println("Error! Command not valid.\n");
            }
        }

    }

    public static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("listM   - List all movies");
        System.out.println("getM    - Get a movie");
        System.out.println("addM    - Add a movie");
        System.out.println("delM    - Delete a movie");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAllMovies() {
        System.out.println("MOVIE LIST");
        List<Movie> movies = MovieDB.getAll();
        for (Movie p: movies) {
            System.out.println(p);
        }
        System.out.println();
    }

    public static void getMovie() {
        System.out.println("GET A MOVIE");
        int id = Console.getInt("Enter movie id: ");
        Movie movie = MovieDB.get(id);
        if (movie != null) {
            System.out.println(movie);
        }
        else {
            System.err.println("No movie found for id: "+id);
        }
        System.out.println();
    }

    public static void addMovie() {
        System.out.println("ADD A MOVIE");
        //int id = Console.getInt("Enter movie id: ");
        String title = Console.getString("Enter movie title: ");
        int year = Console.getInt("Enter movie year: ", 0, 9999);
        String rating = Console.getString("Enter movie rating: ");
        String director = Console.getString("Enter movie director: ");


        Movie m = new Movie();
        m.setTitle(title);
        m.setYear(year);
        m.setRating(rating);
        m.setDirector(director);

        if (MovieDB.add(m)) {
            System.out.println("Movie added!");
        }
    }

    public static void deleteMovie() {
        System.out.println("DELETE A MOVIE");
        boolean success = false;

        while (!success) {
            int id = Console.getInt("Enter ID for movie to delete: ");
            Movie p = MovieDB.get(id);
            if (p == null) {
                System.out.println("No movie for id: "+id+". Please try again.");
            }
            else {
                if (MovieDB.delete(p)) {
                    success = true;
                    System.out.println("Movie successfully deleted!");
                }
            }
        }

    }
}