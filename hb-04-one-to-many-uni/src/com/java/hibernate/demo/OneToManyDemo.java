package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Course;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;
import com.java.hibernate.demo.entity.Review;

public class OneToManyDemo {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {

      int theId = 10;
      Review review1 = new Review("GOOOOD!");
      session.beginTransaction();
      Course course = session.get(Course.class, theId);
      course.add(review1);
      // this will also save tempInstructorDetail object because of CascadeType all
      session.save(course);
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      session.close();
      factory.close();
    }
  }

}
