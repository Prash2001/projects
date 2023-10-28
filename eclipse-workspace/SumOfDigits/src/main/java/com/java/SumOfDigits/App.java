package com.java.SumOfDigits;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Write a Java program that reads a primary integer between 0 and 1000 and adds all the digits in
 * the integer.
 *
 */
public class App {

  public static void main(String[] args) throws OutOfRange {

    Scanner sc = new Scanner(System.in);

    // handling exception due to invalid input
    try {

      int n = sc.nextInt();

      // validating input to check given input is in the range of 0-1000
      if (n < 0 || n > 1000) {

        throw new OutOfRange("Number should be in the range of 0-1000");

      } else {

        // finding sum of digit
        int sum = 0;
        while (n != 0) {

          sum += n % 10;
          n /= 10;

        }

        System.out.println("Sum of Digits = " + sum);

      }

    } catch (InputMismatchException e) {

      System.out.println("Invalid Input!, Please enter integer");
      e.printStackTrace();

    } catch (NoSuchElementException e) {

      e.printStackTrace();

    } catch (IllegalStateException e) {

      e.printStackTrace();

    } catch (OutOfRange e) {

      System.out.println(e.getMessage());

    }

  }

}
