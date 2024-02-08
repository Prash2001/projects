//package com.java.springdemo.entity;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "wish_list")
//public class WishListItems {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id")
//  private int id;
//  
//  @Column(name = "name")
//  private String name;
//  
//  @Column(name = "price")
//  private String price;
//
//  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,  CascadeType.PERSIST, CascadeType.REFRESH})
//  @JoinColumn(name = "customer_id")
//  private Customer customer;
//  /**
//   * @return the name
//   */
//  public String getName() {
//    return name;
//  }
//
//  /**
//   * @param name the name to set
//   */
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  /**
//   * @return the price
//   */
//  public String getPrice() {
//    return price;
//  }
//
//  /**
//   * @param price the price to set
//   */
//  public void setPrice(String price) {
//    this.price = price;
//  }
//
//  /**
//   * @return the id
//   */
//  public int getId() {
//    return id;
//  }
//
//  /**
//   * @param id the id to set
//   */
//  public void setId(int id) {
//    this.id = id;
//  }
//  
//  /**
//   * @return the customer
//   */
//  public Customer getCustomer() {
//    return customer;
//  }
//
//  /**
//   * @param customer the customer to set
//   */
//  public void setCustomer(Customer customer) {
//    this.customer = customer;
//  }
//
//  public WishListItems() {}
//
//  public WishListItems(String name, String price) {
//    this.name = name;
//    this.price = price;
//  }
//
//  @Override
//  public String toString() {
//    return "WishListItems [id=" + id + ", name=" + name + ", price=" + price + "]";
//  }
//  
//}
