package com.java.springdemo.dao;

import java.util.List;
import com.java.springdemo.entity.Product;

public interface ProductDAO {
  public void saveProduct(Product product);

  public List<Product> getProducts();

  public Product getProductById(int id);
}
