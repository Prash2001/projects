package com.java.Pattern;

import java.util.Scanner;

/**
 * 
 * Write a generic program in java that will print the following structure using a recursive
 * function and same again using a single loop only(this should not use a recursive function).
 * *
 * * *
 * * * *
 * * * * *
 * 
 *
 */
public class App {

  // function to print pattern
  public void func(int n) {

    if (n == 0) {
      return;
    }
    System.out.print("* ");
    n = n - 1;
    // recursively calling function
    func(n);

  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Handling exception for invalid input
    try {
      int n = sc.nextInt();
      App a = new App();

      // calling function and moving cursor to new line
      for (int i = 1; i <= n; i++) {
        a.func(i);
        System.out.println();
      }

    } catch (Exception e) {

      System.out.println("Invalid Input!");
      e.printStackTrace();

    }

    sc.close();

  }

}
