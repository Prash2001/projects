package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Course;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;

public class ManyToOneDemo {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {

      int theId = 1;
      Course course1 = new Course("Spring-Boot");
      Course course2 = new Course("Hibernate");
      Course course3 = new Course("Java");
      session.beginTransaction();
      Instructor instructor = session.get(Instructor.class, theId);
      course1.setInstructor(instructor);
      course2.setInstructor(instructor);
      course3.setInstructor(instructor);
      // this will also save tempInstructorDetail object because of CascadeType all
      session.save(course1);
      session.save(course2);
      session.save(course3);
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      session.close();
      factory.close();
    }
  }

}
