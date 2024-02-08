package com.java.springdemo.dao;

import java.util.ArrayList;
import java.util.List;
import com.java.springdemo.entity.Product;

public class TempAttribute {
  Product product;
List<String> sections;

/**
 * @return the product
 */
public Product getProduct() {
  return product;
}

/**
 * @param product the product to set
 */
public void setProduct(Product product) {
  this.product = product;
}

/**
 * @return the sections
 */
public List<String> getSections() {
  return sections;
}

/**
 * @param sections the sections to set
 */
public void setSections(List<String> sections) {
  this.sections = sections;
}

public TempAttribute() {
  sections = new ArrayList<>();
  sections.add("All");
  sections.add("Men");
  sections.add("Women");
  sections.add("Kids");
  sections.add("Accesories");
}

@Override
public String toString() {
  return "TempAttribute [product=" + product + ", sections=" + sections + "]";
}

}
