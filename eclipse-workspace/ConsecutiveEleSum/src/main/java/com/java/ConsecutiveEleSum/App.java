package com.java.ConsecutiveEleSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Use streams to populate a list of integers of size 10 using the random function. Use reduce
 * function, to find the consecutive elements having the highest sum. Print the sum.
 *
 */
public class App {
  
  // Populating list with random numbers
  public static<T> void addToList(List<T> target, Stream<T> source) {
    source.collect(Collectors.toCollection(() -> target));
}
  
  //adding element in global list
  static List<Integer> lst = new ArrayList<Integer>();
  public static void addSum(int a, int b) {
    lst.add(a+b);
  }
  
  public static void main(String[] args) {
    
    // Populating list with random numbers
    List<Integer> list = new ArrayList<>();
    int i=0;
    while(i<10) {
      addToList(list, Stream.of(ThreadLocalRandom.current().nextInt(1000, 10000 + 1)));//stream().max(Integer::compare).get()
      i++;
    }
    System.out.println(list);
    List<Integer> index = Arrays.asList(0,1,2,3,4,5,6,7,8);
    index.stream().forEach(j -> addSum(list.get(j),list.get(j+1)));
    // Printing highest sum of consecutive sum
    System.out.println("Highest sum of consecutive element = "+lst.stream().max(Integer::compare).get());
  }
}
