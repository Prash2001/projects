package com.java.bankingApplication0.customerRequest;

// Response Structure for every API
public class StatusMessageResponse {
  public Integer code;
  public String status;
  public Object payload;

  public StatusMessageResponse(Integer code, String status, Object data) {
    this.code = code;
    this.status = status;
    this.payload = data;
  }
}
