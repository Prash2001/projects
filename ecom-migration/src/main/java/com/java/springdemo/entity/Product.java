package com.java.springdemo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "product")
@Table(name = "ecom_product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "ECOM_ProductDetails")
  private String productDetails;
  @Column(name = "ECOM_Brand")
  private String brand;
  @Column(name = "ECOM_Product_Image_Name")
  private String imageName;
  @Column(name = "ECOM_Product_Actual_Price")
  private int price;
  @Column(name = "ECOM_Product_Discount")
  private String discount;
  @Column(name = "ECOM_Product_Section")
  private String section;

  @ManyToMany(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "wish_list", joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  List<User> users;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the productDetails
   */
  public String getProductDetails() {
    return productDetails;
  }

  /**
   * @param productDetails the productDetails to set
   */
  public void setProductDetails(String productDetails) {
    this.productDetails = productDetails;
  }

  /**
   * @return the brand
   */
  public String getBrand() {
    return brand;
  }

  /**
   * @param brand the brand to set
   */
  public void setBrand(String brand) {
    this.brand = brand;
  }



  /**
   * @return the imageName
   */
  public String getImageName() {
    return imageName;
  }

  /**
   * @param imageName the imageName to set
   */
  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  /**
   * @return the price
   */
  public int getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * @return the discount
   */
  public String getDiscount() {
    return discount;
  }

  /**
   * @param discount the discount to set
   */
  public void setDiscount(String discount) {
    this.discount = discount;
  }

  /**
   * @return the section
   */
  public String getSection() {
    return section;
  }

  /**
   * @param section the section to set
   */
  public void setSection(String section) {
    this.section = section;
  }

  // /**
  // * @return the sections
  // */
  // public List<String> getSections() {
  // return sections;
  // }

  public Product() {
    // sections = new ArrayList<>();
    // sections.add("All");
    // sections.add("Men");
    // sections.add("Women");
    // sections.add("Kids");
    // sections.add("Accesories");
  }

  public Product(String name, String productDetails, String brand, String imageName, int price,
      String discount, String section) {
    this.name = name;
    this.productDetails = productDetails;
    this.brand = brand;
    this.imageName = imageName;
    this.price = price;
    this.discount = discount;
    this.section = section;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", productDetails=" + productDetails
        + ", brand=" + brand + ", imageName=" + imageName + ", price=" + price + ", discount="
        + discount + ", section=" + section + "]";
  }
public void addUser(User user) {
  if(users == null) {
    users = new ArrayList<>();
  }
  users.add(user);
}


}
