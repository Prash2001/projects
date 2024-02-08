package com.java.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NewFortuneService implements FortuneService {
  @Value("${foo.name}")
  private String name;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getNumber() {
    return number;
  }
  public void setNumber(int number) {
    this.number = number;
  }

  @Value("${foo.number}")
  private int number;
  @Override
  public String dailyFortune() {
    File file = new File("C:\\Users\\prashantjapkar\\Desktop\\test.txt");
    Scanner sc;
    List<String> data = new ArrayList<>();
    try {
      sc = new Scanner(file);
      while (sc.hasNextLine()) {
        data.add(sc.nextLine());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    Random random = new Random();
    int index = random.nextInt(data.size());
    return data.get(index);
  }


}
