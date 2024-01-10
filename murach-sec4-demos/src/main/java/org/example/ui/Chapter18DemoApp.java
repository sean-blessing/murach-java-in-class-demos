package org.example.ui;

import java.time.*;

public class Chapter18DemoApp {

    public static void main(String[] args) {
        System.out.println("Chapter 16 Demos App!");

        // 1 - java.time package - p. 585
        LocalDate currentDate = LocalDate.now();
        System.out.println("currentDate: "+currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("currentTime: "+currentTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("currentDateTime: "+currentDateTime);

        LocalDate halloween1 = LocalDate.of(2024, Month.OCTOBER, 31);
        System.out.println("halloween1: "+ halloween1);
        LocalDate halloween2 = LocalDate.of(2024, 10, 31);
        System.out.println("halloween2: "+ halloween2);
        LocalTime startTime1 = LocalTime.of(14, 32);
        System.out.println("startTime1: "+startTime1);
        LocalTime startTime2 = LocalTime.of(14, 32, 45);
        System.out.println("startTime2: "+startTime2);
        LocalDate halloween3 = LocalDate.parse("2024-10-31");
        System.out.println("halloween3: "+ halloween3);
        LocalTime startTime4 = LocalTime.parse("02:32:45");
        System.out.println("startTime4: "+startTime4);
        LocalDateTime startDateTime2 =
                LocalDateTime.parse("2021-10-31T02:32:45.123456789");
        System.out.println("startDateTime2: "+startDateTime2);

        // Get parts of date and time objects - p. 587
        int year = currentDateTime.getYear();
        System.out.println("currentDateTime.getYear(): "+year);
        Month month = currentDateTime.getMonth();
        System.out.println("currentDateTime.getMonth(): "+month);
        int monthValue = currentDateTime.getMonthValue();
        System.out.println("currentDateTime.getMonthValue(): "+monthValue);
        int day = currentDateTime.getDayOfMonth();
        System.out.println("currentDateTime.getDayOfMonth(): "+day);
        int dayOfYear = currentDateTime.getDayOfYear();
        System.out.println("currentDateTime.getDayOfYear(): "+dayOfYear);
        int minute = currentDateTime.getMinute();
        System.out.println("currentDateTime.getMinute(): "+minute);
        int second = currentDateTime.getSecond();
        System.out.println("currentDateTime.getSecond(): "+second);
        int nano = currentDateTime.getNano();
        System.out.println("currentDateTime.getNano(): "+nano);
        DayOfWeek dayOfWeek = currentDateTime.getDayOfWeek();
        System.out.println("currentDateTime.getDayOfWeek(): "+dayOfWeek);
        int hour = currentDateTime.getHour();
        System.out.println("currentDateTime.getHour(): "+hour);



        System.out.println("Bye");

    }
}
