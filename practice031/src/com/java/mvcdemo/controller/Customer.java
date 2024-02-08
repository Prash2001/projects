package com.java.mvcdemo.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.java.mvcdemo.controller.validation.CourseCode;

public class Customer {
private String firstName;
@NotNull(message = "is required")
@Size(min = 1, message ="is required")
private String lastName;
@NotNull(message = "is required")
@Min(value = 0, message = "Number should be Greater than or equal to zero")
@Max(value = 10, message = "Number should be less than or equal to ten")
private Integer freePass;
@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
private String postalCode;
@CourseCode(value = {"JAVA", "LOVE"}, message = "must start with JAVA or LOVE")
private String courseCode;
public String getCourseCode() {
  return courseCode;
}
public void setCourseCode(String courseCode) {
  this.courseCode = courseCode;
}
public String getPostalCode() {
  return postalCode;
}
public void setPostalCode(String postalCode) {
  this.postalCode = postalCode;
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
public Integer getFreePass() {
  return freePass;
}
public void setFreePass(Integer freePass) {
  this.freePass = freePass;
}

}