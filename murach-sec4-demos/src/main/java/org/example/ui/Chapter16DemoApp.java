package org.example.ui;

import org.example.model.Contact;
import org.example.model.TestContact;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Chapter16DemoApp {
    public static void main(String[] args) {
        System.out.println("Chapter 16 Demos App!");
        System.out.println("Lambdas and Streams");

        // 1 - Contact Management - p. 537
        // Review contact class
        System.out.println("Contact Manager - no lambdas");
        // Create some contacts and put in a list
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
        contacts.add(new Contact("Anne Boehm", null, null));
        contacts.add(new Contact("Joel Murach", "joel@murach.com", null));

        displayContacts(contacts, "All contacts:");

        // Get contacts who don't have phone numbers
        List<Contact> contactsNoPhone = filterContactsWithoutPhone(contacts);
        displayContacts(contactsNoPhone, "Contacts Missing Phone:");

        // Get contacts who don't have email addresses
        List<Contact> contactsNoEmail = filterContactsWithoutEmail(contacts);
        displayContacts(contactsNoEmail, "Contacts Missing Email:");

        // 2 - Functional Interfaces to Filter - p. 539
        System.out.println("\nSame things using lambdas:");
        contactsNoPhone = filterContacts(contacts, c -> c.getPhone()==null);
        displayContacts(contactsNoPhone, "Contacts No Phone - Lambda:");

        contactsNoEmail = filterContacts(contacts, c -> c.getEmail()==null);
        displayContacts(contactsNoEmail, "Contacts No Email - Lambda");

        // 3 - Syntax of lambda expressions - p. 541
        // Review variations of the lambda expression in book

        // 4 - Predicate Interface - similar to our TestContact Interface - p. 543




        System.out.println("Bye");
    }

    public static List<Contact> filterContactsWithoutPhone(List<Contact> contacts) {
        List<Contact> contactsWithoutPhone = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getPhone() == null) {
                contactsWithoutPhone.add(c);
            }
        }
        return contactsWithoutPhone;
    }
    public static List<Contact> filterContactsWithoutEmail(List<Contact> contacts) {
        List<Contact> contactsWithoutEmail = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getEmail() == null) {
                contactsWithoutEmail.add(c);
            }
        }
        return contactsWithoutEmail;
    }

//    // filter using custom functional interface
//    public static List<Contact> filterContacts(List<Contact> contacts, TestContact condition) {
//        List<Contact> filteredContacts = new ArrayList<>();
//        for (Contact c : contacts) {
//            if (condition.test(c)) {
//                filteredContacts.add(c);
//            }
//        }
//        return filteredContacts;
//    }

    // filter using Predicate Interface
    public static List<Contact> filterContacts(List<Contact> contacts, Predicate<Contact> condition) {
        List<Contact> filteredContacts = new ArrayList<>();
        for (Contact c : contacts) {
            if (condition.test(c)) {
                filteredContacts.add(c);
            }
        }
        return filteredContacts;
    }


    private static void displayContacts(List<Contact> contacts, String header) {
        System.out.println("\n"+header);
        System.out.println("--------------------");
        for (Contact c: contacts) {
            System.out.println(c);
        }
    }
}
