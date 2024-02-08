package com.java.springdemo;

import java.util.LinkedHashMap;

public class Student {
  private String firstName;
  private String lastName;
  private String[] operatingSystems;

  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public String[] getOperatingSystems() {
    return operatingSystems;
  }

  public void setOperatingSystems(String[] operatingSystems) {
    this.operatingSystems = operatingSystems;
  }

  public void setFavoriteLanguage(String favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
  }

  private String country;
  private String favoriteLanguage;
  private LinkedHashMap<String, String> countryOptions;

  public LinkedHashMap<String, String> getCountryOptions() {
    return countryOptions;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Student() {
    countryOptions = new LinkedHashMap<>();
    countryOptions.put("BR", "Brazil");
    countryOptions.put("FR", "France");
    countryOptions.put("DE", "Germany");
    countryOptions.put("IN", "India");
    countryOptions.put("US", "United States of America");
  }
}
