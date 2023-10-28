package com.java.CommonRegion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    String str2 = sc.nextLine();
    boolean flag =false;
    int count1 =1;
    for(int  i=0;i<str1.length();i++) {
      while(str1.regionMatches(i, str2, i, count1)) {
        count1++;
        flag = true;
      }
      if(flag) {
        if(count1+1==str1.length()) {
          System.out.println(str1.substring(i, count1-1));
          return;
        }
        else {
          System.out.println(str1.substring(i, count1));
          return;
        }
      }
    }
    sc.close();
  }
}
