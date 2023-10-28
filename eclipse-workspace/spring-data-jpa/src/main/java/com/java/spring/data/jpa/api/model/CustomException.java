package com.java.spring.data.jpa.api.model;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomException {

    public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDebugMessage() {
    return debugMessage;
  }

  public void setDebugMessage(String debugMessage) {
    this.debugMessage = debugMessage;
  }

  public List<SubExceptions> getSubErrors() {
    return subErrors;
  }

  public void setSubErrors(List<SubExceptions> subErrors) {
    this.subErrors = subErrors;
  }

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<SubExceptions> subErrors;

    private CustomException() {
        timestamp = LocalDateTime.now();
    }

    CustomException(HttpStatus status) {
        this();
        this.status = status;
    }

    CustomException(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    CustomException(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
