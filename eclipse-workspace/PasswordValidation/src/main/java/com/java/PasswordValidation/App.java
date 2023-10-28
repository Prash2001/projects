package com.java.PasswordValidation;

import java.util.Scanner;

/**
 * Write a Java method to check whether a given string is a valid password.
   Password rules:
   A password must have at least eight characters.
   A password consists of only letters digits and a special character from set !,@,#,&,?
   A password must contain at least two digits and a special character from a given set.

 *
 */
public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String pass = sc.nextLine();
    // checking password length which should not be less than 8
    if (pass.length() < 8) {
      System.out.println("Password must have atleast 8 character");
    } else {
      int digit = 0, alphabet = 0, speChar = 0;
      for (int i = 0; i < pass.length(); i++) {
        int asc = (int) pass.charAt(i);
        // Counting digits in password
        if ((asc >= 48 && asc <= 57)) {
          digit++;
        } 
        // Counting alphabets in password
        else if ((asc >= 65 && asc <= 90) || (asc >= 97 && asc <= 122)) {
          alphabet++;
        } 
        // Counting special character in password
        else if ((asc == 33) || (asc == 64) || (asc == 35) || (asc == 38) || (asc == 63)) {
          speChar++;
        } 
        // Character other than above not allowed hence returning from here
        else {
          System.out.println(pass.charAt(i) + " is not allowed");
          return;
        }
      }
      // Checking if digits are more than 2 and special character are more than 1 or not in password
      if (digit < 2 || speChar < 1) {
        System.out.println("Password must contain atleast 1 special character and 2 digit");
      } else {
        System.out.println("Valid Password");
      }
    }
  }
}
