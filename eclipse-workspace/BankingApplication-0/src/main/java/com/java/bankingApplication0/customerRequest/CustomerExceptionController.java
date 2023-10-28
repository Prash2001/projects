package com.java.bankingApplication0.customerRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
// Controller layer for exception handling
@ControllerAdvice
public class CustomerExceptionController extends ResponseEntityExceptionHandler{
  @ExceptionHandler(value = CustomerNotFoundException.class)
  public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
     return new ResponseEntity<>(new StatusMessageResponse(404,"Customer not found", null), HttpStatus.NOT_FOUND);
}
  
  @ExceptionHandler(value = ForbiddenException.class)
  public ResponseEntity<Object> exception(ForbiddenException exception) {
     return new ResponseEntity<>(new StatusMessageResponse(403,"Under privilage requst", null), HttpStatus.FORBIDDEN);
}
  
  @ExceptionHandler(value = UnknownException.class)
  public ResponseEntity<Object> exception(UnknownException exception) {
     return new ResponseEntity<>(new StatusMessageResponse(500,"Unknown parsing error.", null), HttpStatus.SEE_OTHER);
}
}