package org.example.db;

import org.example.model.Actor;

import java.util.ArrayList;

public class ActorDB {

    private ArrayList<Actor> actors = new ArrayList<>();

    public ActorDB() {
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor a) {
        actors.add(a);
    }

    @Override
    public String toString() {
        return "ActorDB{" +
                "actors=" + actors +
                '}';
    }
}
