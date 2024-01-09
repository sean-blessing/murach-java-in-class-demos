package org.example.db;

import org.example.model.Credit;

import java.util.ArrayList;

public class CreditDB {

    private ArrayList<Credit> credits = new ArrayList<>();

    public CreditDB() {
    }

    public ArrayList<Credit> getCredits() {
        return credits;
    }

    public void setCredits(ArrayList<Credit> credits) {
        this.credits = credits;
    }

    public void addCredit(Credit c) {
        credits.add(c);
    }

    @Override
    public String toString() {
        return "CreditDB{" +
                "credits=" + credits +
                '}';
    }
}
