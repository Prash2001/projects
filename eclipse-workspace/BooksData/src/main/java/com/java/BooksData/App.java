package com.java.BooksData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Create a collection that stores the information about the book's name, author, genre and number
 * of sold copies. Find the author with the highest no. of books sold. Find the number of authors
 * who write nonfiction books. Find books with a number of copies sold greater than 500000.
 * Demonstrate Optional for absent values.
 *
 * 
 */
public class App extends Book {
  public static void main(String[] args) {
    // making list of Authors
    String[] list =
        {"chetan bhagat", "Amrita Pritam", "Jhumpa Lahiri", "R.K. Narayan", "Rabindranath Tagore"};

    // List of genre
    String[] genre =
        {"Fantacy", "Fictional", "Thriller", "Horror", "Mystery", "Non-fiction", "Humor"};
    // Adding name, author, genre, and sodCopies randomly in list of book
    Random r = new Random();
    List<Book> bookList = new ArrayList<Book>();
    for (int i = 0; i < 25; i++) {
      Book book = new Book();
      book.name = "Book" + i;
      book.author = list[r.nextInt(list.length)];
      // skiping some values for testing optional
      if (!(i > 2 && i < 6)) {
        book.genre = genre[r.nextInt(genre.length)];
      }
      book.soldCopies = ThreadLocalRandom.current().nextInt(150000, 600000 + 1);// ThreadLocalRandom.current().nextInt(2,
                                                                                // 12 + 1);
      bookList.add(book);
    }

    // Finding author with maximum number of sold books
    int max = -1;
    String authorWithMaxSoldBooks = "";
    for (String str : list) {
      int copies = bookList.stream().filter(book -> (book.author == str))
          .map(book -> book.getSoldCopies()).reduce(0, (book1, book2) -> book1 + book2);

      if (max < copies) {
        max = copies;
        authorWithMaxSoldBooks = str;
      }
    }
    System.out
        .println("author -> " + authorWithMaxSoldBooks + " and number of books sold -> " + max);

    // Calculating non fiction authors
    int nonFictionAuthors =
        (int) bookList.stream().filter(book1 -> (book1.genre == "Non-fiction")).distinct().count();
    System.out.println("Number of Non-Fiction Writers " + nonFictionAuthors);

    // calculating number of books whose copies are sold more than 500000
    int booksSold = (int) bookList.stream().filter(b -> b.soldCopies > 500000).count();
    System.out
        .println("No of books with a number of copies sold greater than 500000 -> " + booksSold);
    
    //Demonstrating the use of optional
    for (Book b1 : bookList) {
      String gen = Optional.ofNullable(b1.genre).orElseGet(() -> "Unknown");
      System.out.println("Genere of give book is -> " + gen);
    }
  }
}
