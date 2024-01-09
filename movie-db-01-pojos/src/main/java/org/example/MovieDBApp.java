package org.example;

import org.example.model.Actor;
import org.example.model.Credit;
import org.example.model.Movie;

import java.util.Calendar;
import java.util.Date;

public class MovieDBApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Movie Database App!");
        Movie m1 = new Movie(1, "Star Wars: Episode IV - A New Hope", 1976, "PG", "George Lucas");
        Actor a1 = new Actor(1, "Mark", "Hamill", "M", new Date(51, Calendar.SEPTEMBER, 25));
        Credit c1 = new Credit(1, m1, a1, "Luke Skywalker");
        System.out.println(c1);
        System.out.println("Bye");
    }
}