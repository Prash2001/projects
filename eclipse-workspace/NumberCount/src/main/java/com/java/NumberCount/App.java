package com.java.NumberCount;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * You are given a list of integers(repetition allowed) and a number N. You are supposed to find out
 * how many integers there are with exactly N copies of it in the list. Demonstrate Streams, Filters
 * and Function Composition
 *
 */
public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> lst = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 10, 20, 10);
    int n = sc.nextInt();
    long count = lst.stream().filter(i -> i == n).count();
    System.out.println(n + "appear " + count + " time in given list");
  }
}
