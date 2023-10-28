package com.java.Pro;

import java.util.Scanner;

/**
 * 
 * Write a Java program to find the second largest and second smallest element in an array.
 *
 */
public class App {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Number of element : ");

    // Handling exception for invalid input
    try {
      // Taking number of array element as input
      int n = sc.nextInt();
      System.out.println();
      int[] arr = new int[n];

      // Taking input for array
      for (int i = 0; i < n; i++) {

        arr[i] = sc.nextInt();

      }

      int a, b;

      if (arr[1] > arr[0]) {

        a = arr[1];
        b = arr[0];

      } else {

        a = arr[0];
        b = arr[1];

      }

      // Finding largest and second largest element of array
      for (int i = 2; i < arr.length; i++) {

        if (arr[i] > a) {

          b = a;
          a = arr[i];

        } else if (arr[i] < a && arr[i] > b) {

          b = arr[i];

        }

      }

      System.out.println("Largest Number :" + a);
      System.out.println("Second Largest Number :" + b);

    } catch (Exception e) {

      System.out.println("Invalid Input!");
      e.printStackTrace();

    }

  }

}
