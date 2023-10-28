package com.java.OccurenceCount;

import java.util.Scanner;

/**
 * 
 * Write a java program to count the occurrence of given substring in a given input string.
 *
 */
public class App {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String subStr = sc.nextLine();
    int count = 0;

    // Iterating through given string str in such way that inner loop will not go beyond String
    // subStr length
    for (int i = 0; i <= str.length() - subStr.length(); i = i + 1) {
      // string builder for bulding string equal to the length of String subStr
      StringBuilder cStr = new StringBuilder();

      for (int j = i; j < (subStr.length() + i); j++) {
        cStr.append(str.charAt(j));
      }

      // If String cStr matches with subStr we increase counter
      if (cStr.toString().equals(subStr)) {
        count++;
      }

    }

    System.out.println("Occurence of substring in string = " + count);

  }

}
