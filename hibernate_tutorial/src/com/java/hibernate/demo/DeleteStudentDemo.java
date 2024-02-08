package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      System.out.println("Delteting record where FirstName is Paul");
      session.createQuery("delete from Student s where s.firstName = 'Paul'").executeUpdate();
      session.getTransaction().commit();
      System.out.println("Done!");
    }
    finally {
      factory.close();
    }
  }

}
