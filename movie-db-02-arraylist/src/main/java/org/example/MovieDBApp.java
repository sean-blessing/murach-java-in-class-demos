package org.example;

import org.example.db.ActorDB;
import org.example.db.CreditDB;
import org.example.db.MovieDB;
import org.example.model.Actor;
import org.example.model.Credit;
import org.example.model.Movie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MovieDBApp {

    public static void main(String[] args) {
        // initialize db(s)
        MovieDB movieDB = new MovieDB();;
        ActorDB actorDB = new ActorDB();
        CreditDB creditDB = new CreditDB();

        System.out.println("Welcome to the Movie Database App!");

        // Create a movie and add to db
        Movie m1 = new Movie(1, "Star Wars: Episode IV - A New Hope", 1976, "PG", "George Lucas");
        movieDB.addMovie(m1);

        // Create an actor and add to db
        Actor a1 = new Actor(1, "Mark", "Hamill", "M", new Date(51, Calendar.SEPTEMBER, 25));
        actorDB.addActor(a1);

        // Create a credit and add to db
        Credit c1 = new Credit(1, m1, a1, "Luke Skywalker");
        creditDB.addCredit(c1);

        System.out.println(c1);

        System.out.println("Bye");
    }
}