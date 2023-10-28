package com.java.BooksData;

public class Book {
public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }
  public int getSoldCopies() {
    return soldCopies;
  }
  public void setSoldCopies(int soldCopies) {
    this.soldCopies = soldCopies;
  }
String name;
String author;
String genre;
int soldCopies;
}
