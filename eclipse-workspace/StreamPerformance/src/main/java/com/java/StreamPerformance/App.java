package com.java.StreamPerformance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Demonstrate with an example where parallel streams fail to provide results same as normal streams.
 *
 */
public class App 
{
  
  // Calculating time taken by sequential stream to do the calculations
    public static void sequentialStreamTime(List<Integer> lst) {
      long startTime = System.currentTimeMillis();
      int total = lst.stream().reduce(0,(x,y) -> x+y*y-x);
      long duration = System.currentTimeMillis() - startTime;
      System.out.println("Time taken by Sequential Stream in ms-> "+duration);
    }
    
 // Calculating time taken by parallel stream to do the calculations
    public static void parallelStreamTime(List<Integer> lst) {
      long startTime = System.currentTimeMillis();
      int total = lst.stream().parallel().reduce(0,(x,y) -> x+y*y-x);
      long duration = System.currentTimeMillis() - startTime;
      System.out.println("Time taken by Parallel Stream in ms-> "+duration);
    }
    
    
    public static void main( String[] args )
    {
        List<Integer> lst = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        App.sequentialStreamTime(lst);
        App.parallelStreamTime(lst);
    }
}
