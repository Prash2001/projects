package com.java.PatternSingleLoop;

import java.util.Scanner;

/**
 * 
 * Write a generic program in java that will print the following structure using a single loop
 * only(this should not use a recursive function).
 *
 */
public class App {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Handling exception for invalid input
    try {
      int n = sc.nextInt();
      String str = "* ";

      // Loop for printing pattern
      while (n != 0) {

        System.out.print(str);
        // Concatenating String to modify new line of input
        str += "* ";
        System.out.println();
        n--;

      }
    } catch (Exception e) {

      System.out.println("Invalid Input!");


    }

  }

}
