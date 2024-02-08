package com.java.springdemo.service;

import com.java.springdemo.entity.User;

public interface UserService {
  public User getUser(String userName, String password);

  public void addUser(User user);
}
