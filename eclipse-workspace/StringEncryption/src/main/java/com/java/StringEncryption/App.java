package com.java.StringEncryption;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Write a program to print a string encrypted using Caesar Cipher in java using stream and
 * composition. Caesar Cipher: Every alphabet of the sentence is encoded with its third succeeding
 * alphabet. Eg: input: “ATTACK AT DAWN” output: “DWWDFN DW GDZQ”
 *
 */
public class App {
  // StringBuilder for building string
  static StringBuilder strBuilder = new StringBuilder();
  // Recieving ascii from stream and append it to stringbuilder
  static void changeString(int asc) {
    if((char)(asc)==' ') {
      strBuilder.append(' ');
    }
    else {
      strBuilder.append((char)(asc+3));
    }
  }

  public static void main(String[] args) {
    
    String str = "ATTACK AT DAWN";
    // changing characters of string
    str.chars().forEach(i -> changeString(i));
    System.out.println(strBuilder.toString());

  }
}
