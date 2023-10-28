package com.java.IndvidualDigit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a Java program to break a given integer into a sequence of individual digits. Ex integer
 * 12345 will be printed as 1 2 3 4 5.
 *
 */
public class App {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // handling unexpected input
    try {

      int t = sc.nextInt();
      // creating arraylist for adding individual digit
      List<Integer> numList = new ArrayList<Integer>();
      int i = 0;
      while (t != 0) {
        numList.add(t % 10);
        t /= 10;
        i++;
      }
      // printing arraylist in reverse
      for (int j = i - 1; j >= 0; j--) {
        System.out.print(numList.get(j) + " ");
      }

    } catch (Exception e) {

      System.out.println("Invalid input!");

    }
  }
}
