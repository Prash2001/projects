package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Student;

public class ReadStudentDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      System.out.println("Creating Student...........");
      Student tempStudent = new Student("Paul", "Wall", "paul@java.com");
      session.beginTransaction();
      System.out.println("Saving Student........");
      session.save(tempStudent);
      session.getTransaction().commit();
      System.out.println("Done!");
      
      Session newSession = factory.getCurrentSession();
      newSession.beginTransaction();
      System.out.println("\nGetting Student with ID :" + tempStudent.getId());
      Student myStudent = newSession.get(Student.class, tempStudent.getId());
      newSession.getTransaction().commit();
      System.out.println("Get Complete :"+ myStudent);
      
    }
    finally {
      factory.close();
    }
  }

}
