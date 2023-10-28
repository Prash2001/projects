package com.java.StreamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Demonstrate parallel streams are faster than streams.
 *
 */
public class App {
  public static void main(String[] args) {
    
    long start = System.currentTimeMillis();

    IntStream.range(1, 100).forEach(System.out::println);

    //calculating time taken by  normal stream
    long duration = System.currentTimeMillis() - start;

    System.out.println("Normal Stream took -> " + duration + " milliseconds");

    start = System.currentTimeMillis();

    IntStream.range(1, 100).parallel().forEach(System.out::println);

  //calculating time taken by  Parallel stream
    duration = System.currentTimeMillis() - start;

    System.out.println("Parallel Stream took -> " + duration + " milliseconds");

  }
}
