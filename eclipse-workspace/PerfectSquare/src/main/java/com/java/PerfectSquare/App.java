package com.java.PerfectSquare;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Check in a list if there are numbers that are a perfect square of some numbers. If such numbers
 * are present, print ‘Valid List’ with count of those numbers else print ‘Invalid List’.
 * Demonstrate use of Optionals.
 *
 */
public class App {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(32, 22, 34, 64, 12, 33);

    List<Integer> list1 = list.stream().filter(i -> (int) Math.sqrt(i) * Math.sqrt(i) == i)
        .collect(Collectors.toList());
    if(list1.isEmpty()) {
      System.out.println("Invalid List");
    }
    else {
      System.out.println("Valid List "+list1.size());
    }
  }
}
