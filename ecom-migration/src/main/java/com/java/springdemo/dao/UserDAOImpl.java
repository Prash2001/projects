package com.java.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.springdemo.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
  @Autowired
  private SessionFactory sessionfactory;

  @Override
  public User getUser(String userName, String password) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<User> query = currentSession.createQuery(
        "from user where username like :userName and password like :password", User.class);
    query.setParameter("userName", userName);
    query.setParameter("password", password);
    User user = null;
    try {
      user = query.getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public void addUser(User user) {
    Session currentSession = sessionfactory.getCurrentSession();
    currentSession.saveOrUpdate(user);

  }

}
