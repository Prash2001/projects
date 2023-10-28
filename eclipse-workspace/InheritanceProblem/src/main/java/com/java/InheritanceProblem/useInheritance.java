package com.java.InheritanceProblem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.java.CollectionProblem.App;

/**
 * 
 * Inherit the above assignment(16) and solve following problems: Print the input in reverse order
 * Take a number from the user and search the first occurrence in the collection. Accepts another
 * collection of numbers from the user and appends it to the existing collection. Print the output
 * in sorted order.
 *
 */
public class useInheritance {


  public static void main(String[] args) throws NumberFormatException, IOException {

    Scanner sc = new Scanner(System.in);
    App a1 = new App();
    System.out.println("Enter number of elements : ");
    int n = sc.nextInt();
    System.out.println("Enter " + n + " elements :");

    // Creating list of n element
    List<Integer> numList = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {

      numList.add(sc.nextInt());

    }

    System.out.println("Enter element for which you want to get first occcurence :");
    int num = sc.nextInt();

    // finding first occurence of the number num
    int count = 0;
    for (int ele : numList) {

      if (num == ele) {
        System.out.println("Given number occured at : " + count + "th index");
      }

      count++;

    }
    System.out.println("Enter number of elements of the second list :");
    int t = sc.nextInt();
    // Creating list using object of another class
    List<Integer> lst2 = a1.getCollection(t);

    // merging lst2t in numList
    numList.addAll(lst2);

    // Sorting numList
    Collections.sort(numList);
    System.out.println("Sorted Merge List : " + numList);
    // reversing list using method of another class
    numList = a1.reverse(numList);
    System.out.println("Reversing list : " + numList);
  }

}
