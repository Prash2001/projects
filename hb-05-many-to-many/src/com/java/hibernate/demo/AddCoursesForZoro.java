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

public class AddCoursesForZoro {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      int theId = 1;
      Student student = session.get(Student.class, theId);
      Course course1 = new Course("Three Sowrd Style");
      course1.addStudents(student);
      Course course2 = new Course("Onigiri");
      course2.addStudents(student);
      session.save(course2);
      session.save(course1);
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      session.close();
      factory.close();
    }
  }

}
