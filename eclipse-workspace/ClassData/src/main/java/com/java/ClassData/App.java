package com.java.ClassData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a java program for students records using a single collectiodn(with data: Roll number,
 * name, section and marks). Program should have at least more than 20 records of students with 4
 * different sections(A, B, C, D). This data should be random in itself. Use of streams and filters
 * is mandatory. Print the following: All records of student All Records of section A only ordered
 * on basis of roll number(Use collection comparator). Topper among all sections. Topper of section
 * B. Count of students in section C and D.
 *
 * 
 */
public class App {

  public static int studentCount(List<String> studentsOfClassC, List<String> studentsOfClassD) {
    return studentsOfClassC.size() + studentsOfClassD.size();
  }

  public static void printAllRecord(Map<String, List<String>> mappedclass,
      Map<List<String>, List<Integer>> mappedmarks) {
    int count = 0;
    for (String classes : mappedclass.keySet()) {
      count = 0;
      System.out.println("Class " + classes);
      for (String students : mappedclass.get(classes)) {
        System.out.println("Roll Number -> " + (count + 1) + " Name -> " + students + " Marks -> "
            + (mappedmarks.get(mappedclass.get(classes)).get(count)));
        count++;
      }
    }
  }

  public static void classARecord(Map<String, List<String>> mappedclass,
      Map<List<String>, List<Integer>> mappedmarks) {
    int num = 0;
    System.out.println("Class A Records");
    for (String students : mappedclass.get("A")) {
      System.out.println("Roll Number -> " + (num + 1) + " Name -> " + students + " Marks -> "
          + (mappedmarks.get(mappedclass.get("A")).get(num)));
      num++;
    }
  }

  public static void topper(Map<String, List<String>> mappedclass,
      Map<List<String>, List<Integer>> mappedmarks) {
    int max = -1, count1 = 0;
    int topperrollnum = -1;
    String toppersection = "A";
    String toppername = "NA";
    for (String classes : mappedclass.keySet()) {
      for (String students : mappedclass.get(classes)) {
        if (max < mappedmarks.get(mappedclass.get(classes)).get(count1)) {
          max = mappedmarks.get(mappedclass.get(classes)).get(count1);
          topperrollnum = count1 + 1;
          toppersection = classes;
          toppername = students;
        }
        count1++;
      }
      count1 = 0;
    }
    System.out.println("Topper Details");
    System.out.println("Class -> " + toppersection + " Name -> " + toppername + " Roll Number -> "
        + topperrollnum + " Marks -> " + max);
  }

  public static void classBTopper(Map<String, List<String>> mappedclass,
      Map<List<String>, List<Integer>> mappedmarks) {
    int maxB = -1, count2 = 0;
    int topperrollnumB = -1;
    String toppernameB = "NA";
    for (String students : mappedclass.get("B")) {
      if (maxB < mappedmarks.get(mappedclass.get("B")).get(count2)) {
        maxB = mappedmarks.get(mappedclass.get("B")).get(count2);
        topperrollnumB = count2 + 1;
        toppernameB = students;
      }
      count2++;
    }
    System.out.println("Class B Topper Deatails");
    System.out.println(
        "Name -> " + toppernameB + " Roll Number -> " + topperrollnumB + " Marks -> " + maxB);
  }

  public static void main(String[] args) {
    // Making list of students
    List<String> studentsOfClassA = new ArrayList<String>();
    studentsOfClassA.add("ramesh");
    studentsOfClassA.add("suresh");
    studentsOfClassA.add("ram");
    studentsOfClassA.add("sham");
    studentsOfClassA.add("karan");
    studentsOfClassA.add("arjun");
    List<String> studentsOfClassB = new ArrayList<String>();
    studentsOfClassB.add("Luffy");
    studentsOfClassB.add("Zoro");
    studentsOfClassB.add("Sanji");
    studentsOfClassB.add("Brook");
    studentsOfClassB.add("Usoop");
    studentsOfClassB.add("Chopper");
    List<String> studentsOfClassC = new ArrayList<String>();
    studentsOfClassC.add("Tanjiro");
    studentsOfClassC.add("Zenitsu");
    studentsOfClassC.add("Inouske");
    studentsOfClassC.add("Giuu");
    studentsOfClassC.add("Rengoku");
    studentsOfClassC.add("Tengen");
    List<String> studentsOfClassD = new ArrayList<String>();
    studentsOfClassD.add("Gojo");
    studentsOfClassD.add("Sukuna");
    studentsOfClassD.add("Yuji");
    studentsOfClassD.add("sasaki");
    studentsOfClassD.add("Megumi");
    studentsOfClassD.add("Nobara");

    // Creating list of marks for each section
    List<Integer> marksOfClassA = new ArrayList<Integer>();
    List<Integer> marksOfClassB = new ArrayList<Integer>();
    List<Integer> marksOfClassC = new ArrayList<Integer>();
    List<Integer> marksOfClassD = new ArrayList<Integer>();

    // Adding random marks
    for (int i = 1; i < 7; i++) {
      marksOfClassA.add(i + 23);
      marksOfClassB.add(i + 24);
      marksOfClassC.add(i + 25);
      marksOfClassD.add(i + 26);
    }

    // Mapping Class with students Name
    Map<String, List<String>> mappedclass = new HashMap<String, List<String>>();
    mappedclass.put("A", studentsOfClassA);
    mappedclass.put("B", studentsOfClassB);
    mappedclass.put("C", studentsOfClassC);
    mappedclass.put("D", studentsOfClassD);

    // Mapping Student of one class with list of marks of same class
    Map<List<String>, List<Integer>> mappedmarks = new HashMap<List<String>, List<Integer>>();
    mappedmarks.put(studentsOfClassA, marksOfClassA);
    mappedmarks.put(studentsOfClassB, marksOfClassB);
    mappedmarks.put(studentsOfClassC, marksOfClassC);
    mappedmarks.put(studentsOfClassD, marksOfClassD);

    // Printing all the records of the student
    App.printAllRecord(mappedclass, mappedmarks);

    // Printing all the records of class A
    App.classARecord(mappedclass, mappedmarks);

    // Finding topper of school
    App.topper(mappedclass, mappedmarks);

    // Finding total number of students in section C and D
    App.classBTopper(mappedclass, mappedmarks);
    int cplusD = App.studentCount(studentsOfClassC, studentsOfClassD);
    System.out.println(cplusD);



  }
}
