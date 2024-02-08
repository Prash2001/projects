package com.java.mvcdemo.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

  private String[] coursePrefix;
  @Override
  public void initialize(CourseCode theCourseCode) {
    coursePrefix = theCourseCode.value();
  }

  @Override
  public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
    boolean result = false;
    if(theCode != null) {
      for(String tempPrefix : coursePrefix) {
        result = theCode.startsWith(tempPrefix);
        if(result) {
          break;
        }
      }
    }
    else {
      result = true;
    }
    return result;
  }

}