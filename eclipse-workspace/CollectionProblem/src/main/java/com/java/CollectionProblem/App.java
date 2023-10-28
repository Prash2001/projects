package com.java.CollectionProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Write a java program using suitable collection: Accept a collection of numbers from
 * user(duplication of data is allowed) Print the occurrence of each element. Sort the collection in
 * ascending and descending order.
 *
 */
public class App {
  
  Scanner sc1 = new Scanner(System.in);
  
  // Counting and printing occurence of each element
  public void countOccurence(List<Integer> numList) {
    int count;
    boolean flag = false;
    int prevnum = numList.get(0);
    for (Integer num : numList) {
      if (!flag) {
        flag = true;
        prevnum = num + 1;
      }
      if (prevnum == num) {
        continue;
      }
      prevnum = num;
      count = 0;
      ListIterator<Integer> itr = numList.listIterator();
      while (itr.hasNext()) {
        if (num == itr.next()) {
          count++;
        }
      }
      System.out.println(num + " occured " + count + " time");
    }
  }

  // Taking collection as a input from the user
  public List<Integer> getCollection(){
    int n = sc1.nextInt();
    List<Integer> numList = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      numList.add(sc1.nextInt());
    }
    return numList;
  }

  // Sorting arrayList in ascending order
  public List<Integer> sort(List<Integer> numList) {
    Collections.sort(numList);
    return numList;
  }

  // Reversing Arraylist
  public List<Integer> reverse(List<Integer> numList) {
    Collections.reverse(numList);
    return numList;
  }


  public static void main(String[] args) {
    try {
      System.out.println("Enter number of element :");
      App a = new App();
      List<Integer> numList = a.getCollection();
      numList = a.sort(numList);
      System.out.println("Sorted ArrayList in Ascending Order " + numList);
      numList = a.reverse(numList);
      System.out.println("Sorted ArrayList in Descending Order " + numList);
      a.countOccurence(numList);
    } catch (Exception e) {
      System.out.println("Invalid Input!");
      e.printStackTrace();
    }
  }
}
