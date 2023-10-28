package com.java.bankingApplication0.customerRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
// Address Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="ADDRESS")
public class Address {
  @Id
  @Column(name = "address_id")
  private String pincode;
  private String street;
  private String city;
  private String state;
  public String getPincode() {
    return pincode;
  }
  public void setPincode(String pincode) {
    this.pincode = pincode;
  }
  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }



}
