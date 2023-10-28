package com.example.bankingApplication.customerRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
}
