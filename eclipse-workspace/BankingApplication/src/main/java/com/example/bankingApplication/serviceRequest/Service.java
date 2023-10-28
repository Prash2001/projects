package com.example.bankingApplication.serviceRequest;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Table(name="SERVICE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@IdClass(ServicePk.class)
public class Service implements Serializable {

  private static final long serialVersionUID = 1L;

  public Locker getLockerDetails() {
    return lockerDetails;
  }

  public void setLockerDetails(Locker lockerDetails) {
    this.lockerDetails = lockerDetails;
  }

  public Loan getLoanDetails() {
    return loanDetails;
  }

  public void setLoanDetails(Loan loanDetails) {
    this.loanDetails = loanDetails;
  }

  public InternetBanking getiBanking() {
    return iBanking;
  }

  public void setiBanking(InternetBanking iBanking) {
    this.iBanking = iBanking;
  }

  public Service(Locker lockerDetails, Loan loanDetails, InternetBanking iBanking) {//, Address CustomerAddress
    this.lockerDetails = lockerDetails;
    this.loanDetails = loanDetails;
    this.iBanking = iBanking;
  }

  public Service() {};
  @Id
  @OneToOne//(targetEntity = Branch.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "locker_fk", referencedColumnName = "locker_id")
  public Locker lockerDetails;
  
  @OneToOne//(targetEntity = Branch.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "loan_fk", referencedColumnName = "loan_id")
  public Loan loanDetails;
  
  @OneToOne//(targetEntity = Branch.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "internetbanking_fk", referencedColumnName = "transaction_fk")
  public InternetBanking iBanking;
   
}
