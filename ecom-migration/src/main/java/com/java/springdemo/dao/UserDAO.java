package com.java.springdemo.dao;

import com.java.springdemo.entity.User;

public interface UserDAO {
public User getUser(String userName, String password);

public void addUser(User user);
}
