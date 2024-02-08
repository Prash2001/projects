package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      System.out.println("Creating 3 Students...........");
      Student tempStudent1 = new Student("Luffy", "Monkey", "luffy@java.com");
      Student tempStudent2 = new Student("Zoro", "Roronoa", "zoro@java.com");
      Student tempStudent3 = new Student("Sanji", "Vinsmoke", "sanji@java.com");
      session.beginTransaction();
      System.out.println("Saving Students........");
      session.save(tempStudent1);
      session.save(tempStudent2);
      session.save(tempStudent3);
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      factory.close();
    }

  }

}
