package org.example.ui;

public class Chapter14DemoApp {
    public static void main(String[] args) {
        System.out.println("Chapter 14 Demos App");

        // 1 - Methods for comparing strings - p. 467
        String str1 = "Compare Me!";
        String str2 = "compare me!";
        String str3 = "Compare Me!";

        System.out.println("str1 == str2?: "+(str1 == str2)); // false
        System.out.println("str1 == str3?: "+(str1 == str3)); // technically not true, but returns true
        System.out.println("str1 equalsIgnoreCase str2?: "+str1.equalsIgnoreCase(str2));

        String str4 = "aardvark";
        System.out.println("str4 starts with aa?: "+str4.startsWith("aa")); // true
        System.out.println("str4 contains aa?: "+str4.contains("aa"));      // true
        System.out.println("str4 isEmpty?: "+str4.isEmpty());               // false

        // 2 - Methods for working with string indexes - p. 469
        String str5 = "Michael J. Fox";
        System.out.println(str5);
        System.out.println("str5 length: "+str5.length());
        System.out.println("str5 index of ' ': "+str5.indexOf(' '));        // 7
        System.out.println("str5 index of ' ' start 8: "+
                            str5.indexOf(' ', 8));              // 10
        System.out.println("str5 lastIndexOf ' ': "+
                            str5.lastIndexOf(' '));                     // 10
        System.out.println("str5 lastIndexOf ' ' start 9: "+
                            str5.lastIndexOf(' ', 9));          // 7
        System.out.println("str5 charAt 8: "+str5.charAt(8));               // J

        // 3 - Methods for modifying strings - p. 471
        String str6 = "A really long string w/ whitespace at end.       ";
        System.out.println("str6 = '"+str6+"'");
        // trim and reset str6
        str6 = str6.trim();
        System.out.println("str6 trim: '"+str6+"'");
        System.out.println("str6.substring(9): '"+
                            str6.substring(9)+"'");
        System.out.println("str6.replace ' ' with '*': "+
                            str6.replace(' ', '*'));
        System.out.println("str6.toUpperCase(): "+
                            str6.toUpperCase());
        System.out.println("str6.toLowerCase(): "+
                            str6.toLowerCase());

        // 4 - Looping through characters - p. 473
        String str7 = "Hello";
        System.out.println("str7 = "+str7);
        for (int i = 0; i< str7.length(); i++) {
            System.out.println(str7.charAt(i));
        }
        System.out.println("Other methods: isDigit, isLetter, isUpperCase, isLowerCase.. and more!");

        // 5 - Text Blocks (JDK 15) - p. 478
        String str8 = """
                It was the best of times, it was the worst of times,
                it was the age of wisdom, it was the age of foolishness,
                it was the epoch of belief, it was the epoch of incredulity,
                it was the season of Light, it was the season of Darkness,
                it was the spring of hope, it was the winter of despair.
                """;
        System.out.println("quote: "+str8);

        // 6 - Split and join - 481
        String str9 = "java\tMurach's Java\t59.5";
        System.out.println("str9 = "+str9);
        String[] strArr = str9.split("\t");
        System.out.println("str9 split on tab: ");
        for (String s: strArr) {
            System.out.println(s);
        }

        String[] nameParts = {"Eddard", "Ned", "Stark"};
        System.out.println("join 3 strings to full name: "+String.join(" ", nameParts));

        // 7 - String.format - p. 483
        // %s - string, %d - integer, %,.2f. - comma (thousands separator) .2f (2 decimals floatingpoint #)
        String line = "%s is %d years old with sales of $%,.2f.";
        String lineFormatted = String.format(line, "Joel", 39, 58743.0);
        System.out.println("=".repeat(lineFormatted.length()));
        System.out.println(lineFormatted);
        System.out.println("=".repeat(lineFormatted.length()));

        // 8 - StringBuilder - p. 493
        // StringBuilder is way more efficient than String
        System.out.println("Use StringBuilder to build a string...");
        int daysLeft = 3;
        StringBuilder longString = new StringBuilder();
        longString.append("Hello there, how are you?\n");
        longString.append("I'm good how are you?\n");
        longString.append("I really like this class.\n");
        longString.append("Me too! How many days are left?\n");
        longString.append(daysLeft+".\n");
        longString.append("That's not enough!!!\n");

        System.out.println(longString);
        System.out.println("Bye!");
    }
}