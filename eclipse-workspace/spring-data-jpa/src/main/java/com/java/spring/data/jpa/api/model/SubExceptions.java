package com.java.spring.data.jpa.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

abstract class SubExceptions {

  }

  @Data
  @EqualsAndHashCode(callSuper = false)
  @AllArgsConstructor
  class ApiValidationError extends SubExceptions {
     private String object;
     private String field;
     private Object rejectedValue;
     private String message;

     ApiValidationError(String object, String message) {
         this.object = object;
         this.message = message;
     }
}
