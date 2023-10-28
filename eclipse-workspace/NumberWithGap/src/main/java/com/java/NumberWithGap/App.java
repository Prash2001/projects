package com.java.NumberWithGap;

/**
 * Print first 25 numbers from an array with an uniformly increasing gap starting from 0. Eg. 0 1 3
 * 6 10…(See the gap is increasing after every element) No restriction in selecting a uniform way to
 * increase the gap. Demonstrate use of
 *
 * 
 */
public class App {
  public static void main(String[] args) {
    int count =-1,num =0;
   while(count<24) {
     num = num + (count+1);
     System.out.println(num);
     count++;
   }
  }
}
