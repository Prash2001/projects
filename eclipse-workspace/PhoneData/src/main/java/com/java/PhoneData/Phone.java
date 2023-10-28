package com.java.PhoneData;

/**
 * Write a program to store the name, cost, processor name and RAM of phones into a collection.
 * Create 20-25 objects of that collection(use List) and then perform the following operations:-
 * Find the cheapest phone with a snapdragon processor. Find which phone is best in accordance with
 * its RAM and price (price per GB RAM) Retrieve lowest cost per GB RAM Demonstrate Lambda and
 * Streams
 *
 */
public class Phone {
  
public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getCost() {
    return cost;
  }
  public void setCost(int cost) {
    this.cost = cost;
  }
  public String getProcessor() {
    return Processor;
  }
  public void setProcessor(String processor) {
    Processor = processor;
  }
  public int getRam() {
    return ram;
  }
  public void setRam(int ram) {
    this.ram = ram;
  }
String name;
int cost;
String Processor;
int ram;
  
}
