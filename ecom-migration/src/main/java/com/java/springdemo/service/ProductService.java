package com.java.springdemo.service;

import java.beans.JavaBean;
import java.util.List;
import org.springframework.stereotype.Component;
import com.java.springdemo.entity.Product;
@Component()
@JavaBean
public interface ProductService {
  public void saveProduct(Product product);

  public List<Product> getProducts();

  public Product getProductById(int id);
}
