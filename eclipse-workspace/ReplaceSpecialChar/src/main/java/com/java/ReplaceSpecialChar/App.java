package com.java.ReplaceSpecialChar;

import java.util.Scanner;
/**
 * Write a java program that will replace special characters like /,\,:,*,?,”,<,>,| 
 * from the String with _ (underscore). Also use ellipsis if the length of string 
 * exceeds the length 10.
 */
public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    // String builder for building string with _
    StringBuilder sBuild = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      // If String length is greater than 10 replace it with ellipsis
      if (i > 10) {
        sBuild.append("...");
        break;
      }
      int t = (int) str.charAt(i);
      //Replacing special character with _
      if ((t >= 32 && t <= 47) || (t >= 58 && t <= 64) || (t >= 91 && t <= 96)
          || (t >= 123 && t <= 126)) {
        sBuild.append("_");
      } else {
        sBuild.append(str.charAt(i));
      }
    }
    System.out.println(sBuild.toString());
    sc.close();
  }
}
