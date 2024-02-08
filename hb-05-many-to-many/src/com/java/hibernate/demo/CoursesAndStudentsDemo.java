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

public class CoursesAndStudentsDemo {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      Course course = new Course("Spring Boot");
      session.save(course);
      Student student1 = new Student("Luffy", "Monkey", "monkey@java.com");
      Student student2 = new Student("Roronoa", "Zoro", "roronoa@java.com");
      course.addStudents(student1);
      course.addStudents(student2);
      session.save(student1);
      session.save(student2);
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      session.close();
      factory.close();
    }
  }

}
