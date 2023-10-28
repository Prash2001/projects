package com.example.bankingApplication.customerRequest;

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
@Table(name="CARD")
public class CreditCard {
  @Id
  @Column(name = "card_id")
  private String cardNumber;
  private int cardLimit;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
  private Date expiryDate;
}
