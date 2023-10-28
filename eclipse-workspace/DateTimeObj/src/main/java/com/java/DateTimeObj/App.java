package com.java.DateTimeObj;

import java.text.ParseException;
import java.util.Scanner;
import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;

/**
 * Write a java program that can accept date and time separately
 *  in string format and merge it to form the actual datetime object. 
 *  Use the concept of function overloading to implement the same function 
 *  by accepting a Date and Time value.
 *
 */
public class App {
  public static void main(String[] args) throws ParseException, IllegalFieldValueException {
    Scanner sc = new Scanner(System.in);
    String sDate1 = sc.nextLine();
    String newDate;
    // checking string against different valid formats
    if (sDate1.charAt(2) == '/' && sDate1.charAt(5) == '/' && sDate1.length() <= 10) {
      String[] data = sDate1.split("/");
      newDate = data[2] + "-" + data[1] + "-" + data[0];
    } else if (sDate1.charAt(2) == '-' && sDate1.charAt(5) == '-' && sDate1.length() <= 10) {
      String[] data = sDate1.split("-");
      newDate = data[2] + "-" + data[1] + "-" + data[0];
    } else if (sDate1.charAt(4) == '/' && sDate1.charAt(7) == '/' && sDate1.length() <= 10) {
      String[] data = sDate1.split("/");
      newDate = data[0] + "-" + data[1] + "-" + data[2];
    } else if (sDate1.charAt(4) == '-' && sDate1.charAt(7) == '-' && sDate1.length() <= 10) {
      newDate = sDate1;
    } else {
      System.out.println("Invalid date");
      return;
    }
    String myTime = sc.nextLine();
    // Merging date and time
    String dateTime = newDate + "T" + myTime;
    // building standard DateTime object
    DateTime dt = new DateTime(dateTime);
    System.out.println(dt);


  }
}
