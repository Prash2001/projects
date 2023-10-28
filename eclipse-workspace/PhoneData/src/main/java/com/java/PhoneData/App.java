package com.java.PhoneData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Write a program to store the name, cost, processor name and RAM of phones into a collection.
 * Create 20-25 objects of that collection(use List) and then perform the following operations:-
 * Find the cheapest phone with a snapdragon processor. Find which phone is best in accordance with
 * its RAM and price (price per GB RAM) Retrieve lowest cost per GB RAM Demonstrate Lambda and
 * Streams
 *
 */

/**
 * 
 * Using the collection above, store the data into another collection with the key as its processor
 * type and value will be the list of objects having that processor type. Now on this collection
 * perform the following operations: Show details of phones with cost same as or higher than the
 * average cost of all the phones with that processor. Using forEach, print the entire data
 * according to their processors
 *
 * 
 */
public class App extends Phone {

  // Showing details of phones with cost same as or higher than the average cost of all the phones
  // with that processor
  public static void showDetailsOfAboveAverage(Map<String, List<Phone>> mappedPhone) {
    for (String str : mappedPhone.keySet()) {
      System.out.println("----------------------------------------------------------------");
      long avg = mappedPhone.get(str).stream().map(Phone::getCost).mapToInt(i -> i).sum()
          / (mappedPhone.get(str).size());
      mappedPhone.get(str).stream().filter(ph3 -> (ph3.cost >= avg)).forEach(i -> System.out
          .println(i.name + " with processor " + i.Processor + " and cost = " + i.cost));
      System.out.println("----------------------------------------------------------------");
    }
  }

  // Using forEach, printing the entire data according to their processors
  public static void showAllDetails(Map<String, List<Phone>> mappedPhone) {
    for (String str : mappedPhone.keySet()) {
      System.out.println("----------------------------------------------------------------");
      System.out.println(str);
      mappedPhone.get(str).forEach(
          i -> System.out.println("Name = " + i.name + " Ram = " + i.ram + " Cost = " + i.cost));
      System.out.println("----------------------------------------------------------------");
    }
  }

  public static void main(String[] args) {


    List<Phone> phoneList = new ArrayList<Phone>();

    String[] list = {"Snapdragon", "Exynos", "Dimensity 9000", "Apple A15 Bionic", "Google Tensor"};
    Random r = new Random();

    for (int i = 0; i < 25; i++) {
      Phone ph = new Phone();
      ph.name = "Phone" + i;
      ph.cost = ThreadLocalRandom.current().nextInt(15000, 150000 + 1);
      ph.Processor = list[r.nextInt(list.length)];
      ph.ram = ThreadLocalRandom.current().nextInt(2, 12 + 1);
      phoneList.add(ph);
    }
    // cheapest phone with a snapdragon processor.
    Optional<Phone> phone = phoneList.stream().filter(ph -> (ph.Processor == "Snapdragon"))
        .reduce((Phone1, Phone2) -> Phone1.cost > Phone2.cost ? Phone2 : Phone1);
    System.out.println(phone.get().name);

    // best Phone in accordance with its RAM and price
    Optional<Phone> bestPhone = phoneList.stream()
        .reduce((Phone1, Phone2) -> ((Phone1.cost) / (Phone1.ram)) > ((Phone2.cost) / (Phone2.ram))
            ? Phone2
            : Phone1);
    System.out.println(bestPhone.get().name + " Lowest cost per GB RAM -> "
        + ((bestPhone.get().cost) / (bestPhone.get().ram)));

    // storing the data into another collection with the key as its processor type and value will be
    // the list of objects having that processor type.
    Map<String, List<Phone>> mappedPhone = new HashMap<String, List<Phone>>();
    int sum = 0;
    int count = 0;
    for (String str : list) {
      List<Phone> ph =
          (List<Phone>) phoneList.stream().filter(ph1 -> (ph1.Processor == str)).toList();
      mappedPhone.put(str, ph);
    }

    // calling showDetailsOfAboveAverage
    showDetailsOfAboveAverage(mappedPhone);
    
    // calling showAllDetails
    showAllDetails(mappedPhone);

  }
}
