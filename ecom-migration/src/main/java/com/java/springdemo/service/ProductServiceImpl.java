package com.java.springdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.springdemo.dao.ProductDAO;
import com.java.springdemo.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
private ProductDAO productDAO;
  @Override
  @Transactional
  public void saveProduct(Product product) {
    productDAO.saveProduct(product);
  }
  @Override
  @Transactional
  public List<Product> getProducts() {
    return productDAO.getProducts();
  }
  @Override
  @Transactional
  public Product getProductById(int id) {
    // TODO Auto-generated method stub
    return productDAO.getProductById(id);
  }

}
