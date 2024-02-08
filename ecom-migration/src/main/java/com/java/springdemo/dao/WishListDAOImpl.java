package com.java.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.springdemo.entity.WishList;

@Repository
public class WishListDAOImpl implements WishListDAO {
  @Autowired
  private SessionFactory sessionfactory;

  @Override
  public List<WishList> getWishListItems(String username) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<WishList> query = currentSession.createQuery("from wishlist where user_id like :username", WishList.class);
    query.setParameter("username", username);
    List<WishList> items = query.getResultList();
    return items;
  }

}
