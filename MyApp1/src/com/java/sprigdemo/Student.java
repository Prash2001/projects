package com.java.sprigdemo;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.LinkedHashMap;
import org.springframework.web.multipart.MultipartFile;

public class Student {
private String firstName;
private String  lastName;
private String country;
private LinkedHashMap<String, String> countryOptions;
private String favoriteLanguage;
private String[] operatingSystems;
private byte[] data;
private String image;
private MultipartFile file;
private File file1;
private Blob blob;


/**
 * @return the blob
 */
public Blob getBlob() {
  return blob;
}
/**
 * @param blob the blob to set
 */
public void setBlob(Blob blob) {
  this.blob = blob;
}
/**
 * @return the file1
 */
public File getFile1() {
  return file1;
}
/**
 * @param file1 the file1 to set
 */
public void setFile1(File file1) {
  this.file1 = file1;
}
/**
 * @return the file
 */
public MultipartFile getFile() {
  return file;
}
/**
 * @param file the file to set
 * @throws IOException 
 */
public void setFile(MultipartFile file) throws IOException {
  this.file = file;
  this.setData(file.getBytes());
}
/**
 * @return the image
 */
public String getImage() {
  return image;
}
/**
 * @param image the image to set
 */
public void setImage(String image) {
  this.image = image;
}
/**
 * @return the data
 */
public byte[] getData() {
  return data;
}
/**
 * @param data the data to set
 */
public void setData(byte[] data) {
  this.data = data;
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
public String getFavoriteLanguage() {
  return favoriteLanguage;
}
public void setFavoriteLanguage(String favoriteLanguage) {
  this.favoriteLanguage = favoriteLanguage;
}
public String[] getOperatingSystems() {
  return operatingSystems;
}
public void setOperatingSystems(String[] operatingSystems) {
  this.operatingSystems = operatingSystems;
}
public String getCountry() {
  return country;
}
public LinkedHashMap<String, String> getCountryOptions() {
  return countryOptions;
}
public Student() {
  countryOptions = new LinkedHashMap<>();
  countryOptions.put("BR", "Brazil");
  countryOptions.put("FR", "France");
  countryOptions.put("DE", "Germany");
  countryOptions.put("IN", "India");
  countryOptions.put("US", "United States of America");
}
public void setCountry(String country) {
  this.country = country;
}
}
