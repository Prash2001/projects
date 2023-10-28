package com.java.bankingApplication0.customerRequest;

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
//Credit Card Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="CARD")
public class CreditCard {
  @Id
  @Column(name = "card_id")
  private String cardNumber;
  private int cardLimit;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
  private Date expiryDate;
  public Date getExpiryDate() {
    return expiryDate;
  }
  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }
  public String getCardNumber() {
    return cardNumber;
  }
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
  public int getCardLimit() {
    return cardLimit;
  }
  public void setCardLimit(int cardLimit) {
    this.cardLimit = cardLimit;
  }
}
