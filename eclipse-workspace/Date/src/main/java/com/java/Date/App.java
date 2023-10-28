package com.java.Date;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Write a Java program to:
 * Get the dates 10 days before and after today.
 * Get the months remaining in the year.
 * Calculate the difference in minutes between dates captured in the first query.
 *
 */
public class App {
  public static void main(String[] args) {
    DateTime dobj = new DateTime();
    // Obtaining the date 10 days before today
    DateTime bef = dobj.minusDays(10);
    // Obtaining the date 10 days after today
    DateTime aft = dobj.plusDays(10);
    System.out.println(dobj.minusDays(10));
    System.out.println(dobj.plusDays(10));
    // Calculating remaining month in the year
    System.out.println(12 - dobj.getMonthOfYear());
    Duration duration = new Duration(bef, aft);
    System.out.println(duration.getStandardMinutes());
  }
}
