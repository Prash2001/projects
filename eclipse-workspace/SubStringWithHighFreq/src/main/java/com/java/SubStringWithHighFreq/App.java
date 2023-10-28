package com.java.SubStringWithHighFreq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * From a list of strings, find out which of the following is the substring with highest frequency.
 * Demonstrate the use of String manipulation and streams
 *
 * 
 */
public class App {

  public static void main(String[] args) {

    // list of strings
    List<String> strList =
        Arrays.asList("Kunal", "Sanket", "Aniket", "Vivek", "Yash", "Chirag", "Prashant");

    // creating list of all possible subString from the list of given string
    List<String> subString = new ArrayList<String>();
    strList.stream().forEach(str -> {
      for (int i = 0; i < str.length() - 1; i++) {
        for (int j = i + 1; j < str.length(); j++) {
          String sub = str.substring(i, j + 1).toLowerCase();
          subString.add(sub);
        }
      }
    });

    // mapping the subString and frequency of that subString
    Map<String, Integer> stringMapping = new HashMap<String, Integer>();
    subString.stream().forEach(str -> {
      if (stringMapping.get(str) != null) {
        stringMapping.put(str, stringMapping.get(str) + 1);
      } else {
        stringMapping.put(str, 1);
      }
    });

    // finding subString with max frequency
    int max = -1;
    String subStr1 = "";
    for (String keyStr : stringMapping.keySet()) {
      if (max < stringMapping.get(keyStr)) {
        max = stringMapping.get(keyStr);
        subStr1 = keyStr;
      }
    }
    System.out.println("SubString -> " + subStr1 + " Frequency -> " + max);
  }
}
