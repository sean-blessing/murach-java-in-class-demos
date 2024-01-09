package org.example.db;

import org.example.model.Actor;
import org.example.model.Credit;
import org.example.model.Movie;

import java.util.ArrayList;

public class MovieDB {

    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieDB() {
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie m) {
        movies.add(m);
    }

    @Override
    public String toString() {
        return "MovieDB{" +
                "movies=" + movies +
                '}';
    }
}
