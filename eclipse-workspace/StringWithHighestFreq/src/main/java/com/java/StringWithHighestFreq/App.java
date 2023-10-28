package com.java.StringWithHighestFreq;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Read a file from your device and store the data into a list of strings. Now find the length of
 * string with the highest frequency. Demonstrate Streams and Lambda functions.
 *
 * 
 */

/**
 * Collect the above list in a single string, separated by underscore ‘_’. Demonstrate joining
 * function of Collectors.
 *
 * 
 */
public class App {
  public static void main(String[] args) {
    BufferedReader bufReader;
    try {
      // Reading file sample1.txt
      bufReader = new BufferedReader(new FileReader("/Users/prashantjapkar/Downloads/sample1.txt"));
      List<String> listOfWords = new ArrayList<>();
      String line = bufReader.readLine();
      // dividing file into lines
      while (line != null) {
        // dividing line into words
        for (String w : line.split("\\s", 0)) {
          listOfWords.add(w);
        }
        line = bufReader.readLine();
      }
      bufReader.close();
      // mapping word with its count
      Map<String, Integer> mapped = new HashMap<String, Integer>();
      listOfWords.stream().distinct().forEach(str -> {
        mapped.put(str, Collections.frequency(listOfWords, str));
      });
      // finding word with max frequency
      int max = -1;
      String word = "";
      for (String str : mapped.keySet()) {
        if (max < mapped.get(str)) {
          max = mapped.get(str);
          word = str;
        }
      }
      System.out
          .println(word + " of size " + word.length() + " appeard " + max + " number of times");

      // Collecting list of string and joining it using _ delimeter
      String str = listOfWords.stream().collect(Collectors.joining("_"));
      System.out.println(str);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }



  }
}
