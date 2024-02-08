//package com.java.springdemo.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name= "customer")
//public class Customer {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id")
//private int id;
//  @Column(name = "first_name")
//private String firstName;
//  @Column(name = "last_name")
//private String lastName;
//  @Column(name = "email")
//private String email;
//  @OneToMany(mappedBy = "customer", cascade = {CascadeType.DETACH, CascadeType.MERGE,  CascadeType.PERSIST, CascadeType.REFRESH})
//  private List<WishListItems> wishListItems;
//  public int getId() {
//    return id;
//  }
//  public void setId(int id) {
//    this.id = id;
//  }
//  public String getFirstName() {
//    return firstName;
//  }
//  public void setFirstName(String firstName) {
//    this.firstName = firstName;
//  }
//  public String getLastName() {
//    return lastName;
//  }
//  public void setLastName(String lastName) {
//    this.lastName = lastName;
//  }
//  public String getEmail() {
//    return email;
//  }
//  public void setEmail(String email) {
//    this.email = email;
//  }
//  
//  /**
//   * @return the wishListItems
//   */
//  public List<WishListItems> getWishListItems() {
//    return wishListItems;
//  }
//  /**
//   * @param wishListItems the wishListItems to set
//   */
//  public void setWishListItems(List<WishListItems> wishListItems) {
//    this.wishListItems = wishListItems;
//  }
//  public Customer() {
//    
//  }
//  @Override
//  public String toString() {
//    return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
//        + email + "]";
//  }
//  
//  //convieneince method for bidirectional relationship
//public void add(WishListItems item) {
//  if(wishListItems == null) {
//    wishListItems = new ArrayList<>();
//  }
//  wishListItems.add(item);
//  item.setCustomer(this);
//}
//}
