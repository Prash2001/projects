package com.java.spring.data.jpa.api.model;

import java.net.http.HttpHeaders;
import javax.persistence.EntityNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.bankingApplication.customerRequest.StatusMessageResponse;

@ControllerAdvice
public class CustomerExceptionController extends ResponseEntityExceptionHandler{
  @ExceptionHandler(value = CustomerNotFoundException.class)
  public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
     return new ResponseEntity<>(new StatusMessageResponse(404,"Customer not found", null), HttpStatus.NOT_FOUND);
}
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      String error = "Malformed JSON request";
      return buildResponseEntity(new CustomException(HttpStatus.BAD_REQUEST, error, ex));
  }

  private ResponseEntity<Object> buildResponseEntity(CustomException apiError) {
      return new ResponseEntity<>(apiError, apiError.getStatus());
  }
  
  @ExceptionHandler(EntityNotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFound(
          EntityNotFoundException ex) {
      CustomException apiError = new CustomException(HttpStatus.NOT_FOUND);
      apiError.setMessage(ex.getMessage());
      return buildResponseEntity(apiError);
  }
}