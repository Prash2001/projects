package com.example.bankingApplication.serviceRequest;

import java.io.Serializable;
import javax.persistence.Id;
public class ServicePk implements Serializable {
private static final long serialVersionUID = 1L;

@Id
public int lockerNum;
public ServicePk(int lockerNum) {
  this.lockerNum = lockerNum;
}

public ServicePk() {
}
}
