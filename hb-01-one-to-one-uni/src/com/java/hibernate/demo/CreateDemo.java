
package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
//       Instructor tempInstructor = new Instructor("Reyligh", "Silver", "reyligh@java.com");
//       InstructorDetail tenpInstructorDetail = new InstructorDetail("www.youtube.com/java",
//       "Java!!!");
      Instructor tempInstructor = new Instructor("Jiraiya", "of the Sanin", "l=jiraiya@java.com");
      InstructorDetail tenpInstructorDetail =
          new InstructorDetail("www.youtube.com/ToadSage", "Writing");
      tempInstructor.setInstructorDetail(tenpInstructorDetail);
      session.beginTransaction();
      // this will also save tempInstructorDetail object because of CascadeType all
      session.save(tempInstructor);
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      factory.close();
    }
  }

}
