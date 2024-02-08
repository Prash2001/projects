package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;

public class BidirectionalRelationshipDemo {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {

      session.beginTransaction();
      // this will also save tempInstructorDetail object because of CascadeType all
      int theId = 3;
      InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
      System.out
          .println("This is Corresponding Instructor " + tempInstructorDetail.getInstructor());
      System.out.println("Deleting Records!");
      //remove the associated object reference
      //break bidirectional link
      tempInstructorDetail.getInstructor().setInstructorDetail(null);
      session.delete(tempInstructorDetail);
      session.getTransaction().commit();
      System.out.println("Done!");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
      factory.close();
    }

  }

}
