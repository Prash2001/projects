package com.java.hibernate.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.hibernate.demo.entity.Student;

public class QueryStudentDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      List<Student> studentsList = session.createQuery("from Student").list();
      System.out.println("\n\nDisplaying Students :\n\n");
      displayStudents(studentsList);
      System.out.println("\n\nQuerying records with firstname Paul\n\n");
      studentsList = session.createQuery("from Student s where s.firstName = 'Paul'").list();
          displayStudents(studentsList);
            studentsList.get(0).setFirstName("Brook");
            studentsList.get(0).setLastName("SoulKing");
            studentsList.get(0).setEmail("brook@java.com");
            studentsList.get(1).setFirstName("Robin");
            studentsList.get(1).setLastName("Archiologist");
            studentsList.get(1).setEmail("robin@java.com");
          
          System.out.println("\n\nQuerying records with firstName Paul or Lastname Roronoa\n\n");
          studentsList = session.createQuery("from Student s where s.firstName = 'Paul'"+" OR s.lastName = 'Roronoa'").list();
          displayStudents(studentsList);
          System.out.println("\n\nQuerying records who has @java.com in there mail id\n\n");
          studentsList = session.createQuery("from Student s where s.email LIKE '%@java.com'").list();
          displayStudents(studentsList);
      session.getTransaction().commit();
      System.out.println("\n\nDone!\n\n");
    }
    finally {
      factory.close();
    }
  }

  private static void displayStudents(List<Student> studentsList) {
    for(Student tempStudent : studentsList) {
      System.out.println(tempStudent);
    }
  }

}
