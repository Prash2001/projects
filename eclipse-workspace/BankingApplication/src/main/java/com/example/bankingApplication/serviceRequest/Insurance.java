package com.example.bankingApplication.serviceRequest;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "INSURANCE")
public class Insurance {
  @Id 
  @Column(name = "insurance_id")
  public int insuranceId;
  public int getInsuranceId() {
    return insuranceId;
  }
  public void setInsuranceId(int insuranceId) {
    this.insuranceId = insuranceId;
  }
  public String getTypeOfInsurance() {
    return TypeOfInsurance;
  }
  public void setTypeOfInsurance(String typeOfInsurance) {
    TypeOfInsurance = typeOfInsurance;
  }
  public int getInsuranceAmount() {
    return InsuranceAmount;
  }
  public void setInsuranceAmount(int insuranceAmount) {
    InsuranceAmount = insuranceAmount;
  }
  public int getInsuranceAccNum() {
    return InsuranceAccNum;
  }
  public void setInsuranceAccNum(int insuranceAccNum) {
    InsuranceAccNum = insuranceAccNum;
  }
  public Date getInsuranceValidity() {
    return InsuranceValidity;
  }
  public void setInsuranceValidity(Date insuranceValidity) {
    InsuranceValidity = insuranceValidity;
  }
  public String TypeOfInsurance;
  public int InsuranceAmount;
  public int InsuranceAccNum;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
  public Date InsuranceValidity;

}
