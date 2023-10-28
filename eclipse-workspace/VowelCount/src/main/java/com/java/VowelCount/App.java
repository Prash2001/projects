package com.java.VowelCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Count the number of each vowel present in a string: Eg: String=“Bolder Future. Designed And
 * Engineered.” Output: a=1,e=8,i=2,o=1,u=2; Demonstrate Streams and Function Composition
 *
 */
public class App {
  static int[] arr = new int[6];

  public static void main(String[] args) {
    String str = "Bolder Future. Designed And Engineered";

    String lstr = str.toLowerCase();

    List<Integer> num =
        lstr.chars().filter(ch -> (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'))
            .boxed().collect(Collectors.toList());
    Map<Character, Integer> vowelMapping = new HashMap<Character, Integer>();
    num.stream().forEach(asc -> {
      if (vowelMapping.get(Character.toChars(asc)[0]) != null) {
        vowelMapping.put(Character.toChars(asc)[0],
            vowelMapping.get(Character.toChars(asc)[0]) + 1);
      } else {
        vowelMapping.put(Character.toChars(asc)[0], 1);
      }
    });
    System.out.println(vowelMapping);


  }
}
