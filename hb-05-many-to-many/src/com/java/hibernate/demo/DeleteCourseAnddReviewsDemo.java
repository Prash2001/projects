package com.java.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.java.hibernate.demo.entity.Course;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;
import com.java.hibernate.demo.entity.Review;

public class DeleteCourseAnddReviewsDemo {

  public static void main(String[] args) {
    SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {

      int theId = 11;
      session.beginTransaction();
   // this will also delete Reviews object because of CascadeType all
      Course course = session.get(Course.class, theId);
      session.delete(course);
      theId =4;
      Query<Review> query = session.createQuery("Select i From Review i Where i.id =:theReviewID", Review.class);
      query.setParameter("theReviewID", theId);
      Review review = query.getSingleResult();
      session.delete(review);
      session.getTransaction().commit();
      System.out.println("Done!");
    } finally {
      session.close();
      factory.close();
    }
  }

}
