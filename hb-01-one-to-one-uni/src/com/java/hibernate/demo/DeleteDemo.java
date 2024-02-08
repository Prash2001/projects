

package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      int theId = 1;
      Instructor instructor = session.get(Instructor.class, theId);
      System.out.println("Found Instructor : " + instructor);
      if (instructor != null) {
        System.out.println("Deleting Instructor : " + instructor);
        // this will also delete tempInstructorDetail object because of CascadeType all
        session.delete(instructor);
      }
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      factory.close();
    }
  }

}