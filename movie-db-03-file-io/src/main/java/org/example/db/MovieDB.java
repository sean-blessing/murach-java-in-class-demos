package org.example.db;

import org.example.model.Movie;


import java.io.*;
import java.util.ArrayList;

public class MovieDB {

    private static final String FILENAME = "movies.txt";
    private static final String COLUMN_SEP = "\t";

    public MovieDB() {
    }

    public static ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(
                new FileReader(FILENAME))) {

            String line = in.readLine();
            while (line != null) {
                String[] columns = line.split(COLUMN_SEP);
                String idStr = columns[0];
                String title = columns[1];
                String yearStr = columns[2];
                String rating = columns[3];
                String director = columns[4];

                Movie m = new Movie(Integer.parseInt(idStr), title, Integer.parseInt(yearStr), rating, director);
                movies.add(m);

                line = in.readLine();
            }
            return movies;
        }
        catch (FileNotFoundException e) {
            System.out.println(FILENAME + " doesn't exist.");
            return null;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void saveAll(ArrayList<Movie> movies) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(FILENAME)))) {

            // write all products to the file
            for (Movie m : movies) {
                out.print(m.getId() + COLUMN_SEP);
                out.print(m.getTitle() + COLUMN_SEP);
                out.print(m.getYear()+ COLUMN_SEP);
                out.print(m.getRating() + COLUMN_SEP);
                out.println(m.getDirector());
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
