package com.example.bankingApplication.serviceRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.bankingApplication.customerRequest.StatusMessageResponse;

@ControllerAdvice
public class ServiceExceptionController {

  @ExceptionHandler(value = ServiceNotFoundException.class)
  public ResponseEntity<Object> exception(ServiceNotFoundException exception) {
     return new ResponseEntity<>(new StatusMessageResponse(404,"Service not found", null), HttpStatus.NOT_FOUND);
}
}
