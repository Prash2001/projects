package com.java.spring.data.jpa.api.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception{

  private static final long serialVersionUID = 1L;
}
