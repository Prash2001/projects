package com.java.CurrentDateTime;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Write a java program to print current date or time in following formats: MM/dd/yyyy 
 * HH:mm:ss
 * yyyy-MM-dd'T'HH:mm:ssZ 
 * hh:mm a 
 * HH:mm:ss
 * MMM dd yyyy
 *
 */
public class App {
  public static void main(String[] args) {
    // Getting current time
    LocalDateTime date = LocalDateTime.now();
    // formating date for "MM/dd/yyyy HH:mm:ss" pattern
    DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
    String dateTime = fmt.print(date);
    System.out.println(dateTime);
    // formating date for "yyyy-MM-dd'T'HH:mm:ssZ" pattern
    DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    String standardTime = fmt1.print(date);
    System.out.println(standardTime);
    // formating date for "hh:mm a" pattern
    DateTimeFormatter fmt2 = DateTimeFormat.forPattern("hh:mm a");
    String time = fmt2.print(date);
    System.out.println(time);
    // formating date for "HH:mm:ss" pattern
    DateTimeFormatter fmt3 = DateTimeFormat.forPattern("HH:mm:ss");
    String time2 = fmt3.print(date);
    System.out.println(time2);
    // formating date for "MMM dd yyyy" pattern
    DateTimeFormatter fmt4 = DateTimeFormat.forPattern("MMM dd yyyy");
    String date1 = fmt4.print(date);
    System.out.println(date1);
  }
}

