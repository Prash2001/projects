package com.java.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Write a program to store names in a collection where duplication is not allowed. Copy this data
 * into another collection having a key value pair where the key will be the index of the first
 * collection and the value will be the data at that index of the first collection. Perform the
 * following on second collection:List all key and corresponding values. List all available Values
 * keys only in sorted order. Delete a provided value.Check whether provided value is available.
 * Check for empty collections. NOTE: Try to create a menu based program for the above problem (For
 * point a to e).
 *
 */
public class WorkWithMap {

  // Function for sorting HashSet
  public static void sortMySet(Set<Integer> mySet) {
    List<Integer> list = new ArrayList<Integer>(mySet);
    Collections.sort(list);
    System.out.println("Sorted keySet :" + list);
  }

  // extracting keyset from HashMap
  public static Set<Integer> giveMeKeySet(Map<Integer, String> myMap) {
    Set<Integer> numSet = new HashSet<Integer>();
    numSet = myMap.keySet();
    return numSet;
  }

  // Copy Set to HashMap(Index-> key , Corresponding value->value)
  public static Map<Integer, String> copyCollection(Set<String> numSet) {
    Map<Integer, String> newMap = new HashMap<Integer, String>();
    Iterator<String> itr = numSet.iterator();
    int index = 0;
    while (itr.hasNext()) {
      newMap.put(index, itr.next());
      index++;
    }
    System.out.println(newMap);
    return newMap;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Creating set of integer
    Set<String> numSet = new HashSet<String>();
    System.out.println("Enter number of element you want to add :");
    int n = sc.nextInt();
    // System.out.println();
    while (n != 0) {
      numSet.add(sc.next());
      n--;
    }
    System.out.println(numSet);
    Map<Integer, String> myMap = copyCollection(numSet);
    Set<Integer> Set = giveMeKeySet(myMap);
    sortMySet(Set);


  }
}
