package com.java.DistanceFormating;

import java.util.Scanner;

/**
 * Write a Java program to take the user input for a distance (in meters) and the time taken (as
 * three numbers: hours, minutes, seconds), and display the speed, in meters per second, kilometers
 * per hour and miles per hour (Use: 1 mile = 1609 meters). Test DataInput distance in meters: 2500
 * Input hour: 5 Input minutes: 56 Input seconds: 23
 */
public class App {
  
  // finding speed in m/s
  public void sInMps(int distance, int hour, int minute, int second) {
    double speed = (double) distance / ((hour * 60 * 60) + (minute * 60) + second);
    System.out.println("Speed in MPS :" + speed);
  }

  // finding speed in km/hr
  public void sInKph(int distance, int hour, int minute, int second) {
    double time = hour + (minute / 60) + (second / 3600);
    double dInKm = distance / 1000;
    double speed = (double) dInKm / time;
    System.out.println("Speed in KPH :" + speed);
  }

  // finding speed in miles/hr
  public void sInMilesph(int distance, int hour, int minute, int second) {
    double time = hour + (minute / 60) + (second / 3600);
    double dInM = distance / 1609.34;
    double speed = (double) dInM / time;
    System.out.println("Speed in MilesPH :" + speed);
  }

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    // handling exception
    try {
      System.out.print("Input Distance In Meter : ");
      int dInMeter = sc.nextInt();
      System.out.println();
      System.out.print("Input Hour : ");
      int tInHour = sc.nextInt();
      System.out.println();
      System.out.print("Input Minute : ");
      int tInMinute = sc.nextInt();
      System.out.println();
      System.out.print("Input Seconds : ");
      int tInSecond = sc.nextInt();
      System.out.println();
      App a = new App();
      a.sInKph(dInMeter, tInHour, tInMinute, tInSecond);
      a.sInMps(dInMeter, tInHour, tInMinute, tInSecond);
      a.sInMilesph(dInMeter, tInHour, tInMinute, tInSecond);
      sc.close();
    } catch (Exception e) {
      System.out.println("Invalid input");
    }
  }
}
