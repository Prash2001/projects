package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Student;

public class CreateStudentDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      System.out.println("Creating Student...........");
      Student tempStudent = new Student("Roger", "Gol", "roger@java.com");
      session.beginTransaction();
      System.out.println("Saving Student........");
      session.save(tempStudent);
      session.getTransaction().commit();
      System.out.println("Done!");
    }
    finally {
      factory.close();
    }
  }

}
