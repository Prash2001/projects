package com.java.DateTime;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Write a java program that can accept a datetime and timezone 
 * in string format and convert it to a DateTime value 
 * in UTC timezone with keeping datetime value as it is. Use the 
 * concept of function overloading to 
 *
 */
public class App {
  public static String[] dateTimeFormater(String date, String delimeter) {
    String[] data = date.split(delimeter);
    return data;
  }

  public static String[] dateTimeFormater(String time, int delimeter) {
    String str = Character.toString((char) delimeter);
    String[] tData = time.split(str);
    return tData;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String date = sc.nextLine();
    String time = sc.nextLine();
    StringBuilder del = new StringBuilder();
    String[] data = dateTimeFormater(date, del.append(date.charAt(2)).toString());
    int day = Integer.parseInt(data[0]);
    int month = Integer.parseInt(data[1]);
    int year = Integer.parseInt(data[2]);
    StringBuilder del2 = new StringBuilder();
    System.out.println(del2);
    int delmtr = time.charAt(2);
    String[] tData = dateTimeFormater(time, delmtr);
    int hr = Integer.parseInt(tData[0]);
    int min = Integer.parseInt(tData[1]);
    int sec = Integer.parseInt(tData[2]);
    int nanosec = Integer.parseInt(tData[3]);
    LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hr, min, sec, nanosec);
    System.out.println(localDateTime);
  }
}
