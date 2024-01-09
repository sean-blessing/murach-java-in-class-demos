package org.example.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chapter08DemosApp {
    public static void main(String[] args) {
        System.out.println("Chapter 8 Demos App");

        // 1 - Create some Arrays - p. 239
        //String[] studentNames = new String[13];
        int[] numbers = new int[10];

        // 2 - Assign values - p. 241
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;
        numbers[5] = 6;
        numbers[6] = 7;
        numbers[7] = 8;
        numbers[8] = 9;
        numbers[9] = 10;

        // 3 - Create and assign one statement - p. 241
        String[] studentNames = {"Alena", "Jason", "Todd", "Eric", "Wendel", "Mitch", "Will", "Aaron", "Ratz", "Danielle", "Ryan"};

        // 4 - for loop to print values of Array - p. 243
        System.out.println(studentNames);
        for (int i=0; i < studentNames.length; i++) {
            System.out.println(studentNames[i]);
        }

        // 5 - Enhanced for loop - p. 243
        for (int n: numbers) {
            System.out.println("n = "+n);
        }

        // 6 - Rectangular (two-dimensional) Arrays (see tic-tac-toe example at bottom) - p. 245

        // 7 - Arrays class - fill, sort, toString - p. 247
        Arrays.sort(studentNames);
        for (String name: studentNames) {
            System.out.println(name);
        }

        int[] ints = new int[5];
        Arrays.fill(ints, 1);
        for (int i: ints) {
            System.out.println(i);
        }

        // binary search
        // find the index position of Ratz in our studentNames
        int index = Arrays.binarySearch(studentNames, "Ratz");
        System.out.println("Ratz is in position "+index);

        // toString
        System.out.println(Arrays.toString(studentNames));

        // 8 - No demo - reference p. 253, how arrays and array lists are similar, different

        // 9 - Create ArrayLists - p. 255
        //     capacity (default is 10), java 7, java 10 comparison
        ArrayList<String> artists = new ArrayList<String>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();  //JDK 7 or later
        var codes = new ArrayList<String>();  // JDK 10 or later
        ArrayList<Double> prices = new ArrayList<Double>(1000);

        // 10 - Methods of ArrayList - add(int), add(int, obj), get(int), size() - p. 257
        artists.add("Bob Marley");
        artists.add("Taylor Swift");
        artists.add("Billy Eilish");
        artists.add("Test");

        System.out.println("artists = "+artists);
        artists.add(2, "Dummy");

        System.out.println("artists = "+artists);

        // get element 3
        System.out.println(artists.get(3));

        // 11 - More methods of ArrayList - p. 259
        //      Use indexOf to find something in an array

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Index position to get: ");
//        index = sc.nextInt();
        // skipping - will save for lab.

        // remove something from list of artists and confirm removal

        System.out.println("remove an artist");
        Scanner sc = new Scanner(System.in);
        System.out.println("list of artists: "+artists);
        System.out.print("Which id would you like to remove? ");
        int id = sc.nextInt();
        String artistRemoved = artists.remove(id - 1);

        System.out.println("Artist removed: "+artistRemoved);

        System.out.println("Refreshed list of artists: "+artists);

        System.out.println("Bye!");
    }
}