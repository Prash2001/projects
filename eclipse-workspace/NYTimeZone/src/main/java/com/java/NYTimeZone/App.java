package com.java.NYTimeZone;

import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Write a java program to get the current time in New York and print the day(in 3 letter format and
 * complete day name), date, month(in 3 letter format and complete month name), year in current
 * timezone. Also print epoch time
 *
 */
public class App {
  public static void main(String[] args) {
    /**
     * getting day and month in 3 letter format
     *
     */
    try {
      // New York Time-Zone
      DateTimeZone zone = DateTimeZone.forID("America/New_York");
      // Getting date and time of New York time zone
      DateTime dt = new DateTime(zone);
      // Formatter for date formating
      DateTimeFormatter fmt = DateTimeFormat.forPattern("dd MMM, yyyy");
      String dateTimeYear = fmt.print(dt);
      Date str = dt.toDate();
      String day = str.toString();
      StringBuilder ddd = new StringBuilder();
      // getting only first 3 letters of the day
      for (int i = 0; i < 3; i++) {
        ddd.append(day.charAt(i));
      }
      System.out.format("%s,%s\n", ddd.toString(), dateTimeYear);
      /**
       * getting full name of day and month in date
       *
       */
      int numDay = str.getDay();
      LocalDate date = new LocalDate();
      date = date.withDayOfWeek(numDay);
      DateTimeFormatter fmt2 = DateTimeFormat.forPattern("dd MMMM, yyyy");
      String dateTimeYear2 = fmt2.print(dt);
      System.out.print(DateTimeFormat.forPattern("EEEE").print(date));
      System.out.println(", " + dateTimeYear2);
      // epoch time
      LocalDateTime nowLocal = new LocalDateTime();
      DateTime nowUTC = nowLocal.toDateTime(zone.UTC);
      System.out.println(nowUTC);
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid time zone or Invalid pattern ");
    }
  }
}
