package com.java.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.springdemo.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
  @Autowired
  private SessionFactory sessionfactory;

  @Override
  public void saveProduct(Product product) {
    Session currentSession = sessionfactory.getCurrentSession();
    currentSession.saveOrUpdate(product);
  }

  @Override
  public List<Product> getProducts() {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<Product> query = currentSession.createQuery("from product", Product.class);
    List<Product> products = query.getResultList();
    return products;
  }

  @Override
  public Product getProductById(int id) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<Product> query = currentSession.createQuery("from product where id like :id", Product.class);
    query.setParameter("id", id);
    Product product = query.getSingleResult();
    return product;
  }

}
