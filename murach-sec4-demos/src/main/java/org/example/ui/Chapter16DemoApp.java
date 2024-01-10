package org.example.ui;

import org.example.model.Contact;
import org.example.model.TestContact;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chapter16DemoApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Chapter 16 Demos!");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
        contacts.add(new Contact("Anne Boehm", null, null));
        contacts.add(new Contact("Joel Murach", "joel@murach.com", null));

        displayContacts(contacts, "All Contacts:");

//        List<Contact> contactsNoPhone = filterContactsNoPhone(contacts);
//        displayContacts(contactsNoPhone, "Contacts No Phone #:");
//
//        List<Contact> contactsNoEmail = filterContactsNoEmail(contacts);
//        displayContacts(contactsNoEmail, "Contacts No Email:");
//
//        System.out.println("Now use lambdas...");
//        contactsNoPhone = filterContacts(contacts,
//                            c -> c.getPhone()==null);
//        displayContacts(contactsNoPhone, "No Phone, using lambda:");
//
//        contactsNoEmail = filterContacts(contacts,
//                c -> c.getEmail()==null);
//        displayContacts(contactsNoEmail, "No Email, using lambda:");

        // use a stream to filter a list - get contacts with no phone
        System.out.println("Use a stream - contacts no phone");
        contacts.stream().filter(c -> c.getPhone() == null).forEach(c -> System.out.println(c.getName()));

        // filter a list and collect elements
        List<Contact> contactsNoPhone = contacts.stream().
                        filter(c -> c.getPhone() == null).collect(Collectors.toList());
        System.out.println("There are " + contactsNoPhone.size() + " contacts with no phone number.");


        System.out.println("Bye");
    }

    private static void displayContacts(List<Contact> contacts, String header) {
        System.out.println(header);
        System.out.println("==================");
        for (Contact c: contacts) {
            System.out.println(c);
        }
    }

    private static List<Contact> filterContactsNoPhone(List<Contact> contacts) {
        List<Contact> contactsNoPhone = new ArrayList<>();
        for (Contact c: contacts) {
            if (c.getPhone()==null) {
                contactsNoPhone.add(c);
            }
        }
        return contactsNoPhone;
    }

    private static List<Contact> filterContactsNoEmail(List<Contact> contacts) {
        List<Contact> contactsNoEmail = new ArrayList<>();
        for (Contact c: contacts) {
            if (c.getEmail()==null) {
                contactsNoEmail.add(c);
            }
        }
        return contactsNoEmail;
    }

    private static List<Contact> filterContacts(List<Contact> contacts,
                                                Predicate<Contact> condition) {
        List<Contact> filteredContacts = new ArrayList<>();
        for (Contact c: contacts) {
            if (condition.test(c)) {
                filteredContacts.add(c);
            }
        }
        return filteredContacts;
    }
}
