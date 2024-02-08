package com.java.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.springdemo.dao.UserDAO;
import com.java.springdemo.entity.User;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDAO userDAO;

  @Override
  @Transactional
  public User getUser(String userName, String password) {
    return userDAO.getUser(userName, password);
  }

  @Override
  @Transactional
  public void addUser(User user) {
    userDAO.addUser(user);
    
  }

}
