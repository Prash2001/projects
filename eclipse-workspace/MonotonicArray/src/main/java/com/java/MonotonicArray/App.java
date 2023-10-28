package com.java.MonotonicArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Check if an array is a monotonic array(an array that is either strictly increasing or strictly
 * decreasing) or not. Demonstrate use of streams and sort methods for ascending and descending
 * order sorting.
 *
 */
public class App {
  static boolean bool  = false;
  static boolean bool1  = false;
  // checking if list is strictly increasing or not
  public static void isIncreasing(int num1, int num2) {
    if(!(num1<num2)) {
      bool = true;
    }
  }
  // checking if list is strictly decreasing or not
  public static void isDecreasing(int num1, int num2) {
    if(!(num2<num1)) {
      bool1 = true;
    }
  }
  public static void main(String[] args) {

    List<Integer> arr = Arrays.asList(100,90,80,70,60,50,40,30,20,10);
    //List<Integer> arr = Arrays.asList(10,20,30,40,50,60,70,80,90,100);
    //List<Integer> arr = Arrays.asList(10,20,30,40,50,60,70,80,90,10);
    IntStream.range(0,arr.size()-1).forEach(i -> {
      isIncreasing(arr.get(i),arr.get(i+1));
  });
    IntStream.range(0,arr.size()-1).forEach(i -> {
      isDecreasing(arr.get(i),arr.get(i+1));
  });

    // if list is not increasing or decreasing strictly
    if(bool1&&bool) {
      System.out.println("Given list is not monotonic");
    }
    else {
      System.out.println("Given list is monotonic");
    }
  }
}
