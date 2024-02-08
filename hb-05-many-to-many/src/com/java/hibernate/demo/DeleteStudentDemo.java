package com.java.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.java.hibernate.demo.entity.Course;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;
import com.java.hibernate.demo.entity.Review;
import com.java.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {

      int theId = 2;
      session.beginTransaction();
   // this will also delete Reviews object because of CascadeType all
      Student student = session.get(Student.class, theId);
      session.delete(student);
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      session.close();
      factory.close();
    }
  }

}
