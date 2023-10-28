package com.example.bankingApplication.service;

import java.time.Instant;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bankingApplication.customerRequest.Branch;
import com.example.bankingApplication.customerRequest.Customer;
import com.example.bankingApplication.repository.BillPayRepository;
import com.example.bankingApplication.repository.BranchRepository;
import com.example.bankingApplication.repository.CustomerRepository;
import com.example.bankingApplication.repository.InsuranceRepository;
import com.example.bankingApplication.repository.InternetBankingRepository;
import com.example.bankingApplication.repository.LoanRepository;
import com.example.bankingApplication.repository.LockerRepository;
import com.example.bankingApplication.repository.OnlineTransactionRepository;
import com.example.bankingApplication.repository.ServiceRepository;
import com.example.bankingApplication.serviceRequest.*;

@Service
public class ServiceService {
  @Autowired
  private BranchRepository brRepository;
 @Autowired
 private CustomerRepository cRepository;
  @Autowired
  private ServiceRepository repository;
  @Autowired
  private LockerRepository lcRepository;
  
  @Autowired
  private LoanRepository lRepository;
  
  @Autowired
  private InternetBankingRepository iRepository;
  
  @Autowired
  private BillPayRepository bRepository;
  
  @Autowired
  private OnlineTransactionRepository oRepository;
  
  @Autowired
  private InsuranceRepository inRepository;
  @PostConstruct
  public void initDB() {
    Customer c1 = cRepository.findByCustomerId(123);
    Branch b1 = brRepository.findByBranchCode(8213);
    Loan l1 = new Loan();
    l1.customerId = c1.getCustomerId();
    l1.loanAmount = 250000;
    l1.loanNumber = 1234;
    lRepository.save(l1);
    
    Locker lc1 = new Locker();
    lc1.customerAccNum = c1.customerAccNum;
    lc1.lockerNum = 1;
    lc1.branchNum = 1;
    lcRepository.save(lc1);
    
    OnlineTransaction ot1 = new OnlineTransaction();
    ot1.customerAccNum = c1.customerAccNum;
    ot1.BenificiaryAccNum = c1.customerAccNum;
    ot1.ISFCCode = b1.getBranchIFSCCode();
    
    BillPay bill1 = new BillPay();
    bill1.BillNum = 1;
    bill1.AmountToPay = 25000;
    bill1.TypeOfBill = "Electricity";
    bRepository.save(bill1);
    
    Insurance i1  = new Insurance();
    i1.insuranceId = 1;
    i1.InsuranceAmount = 25000;
    i1.InsuranceValidity = Date.from(Instant.now());
    i1.InsuranceAccNum = c1.customerAccNum;
    i1.TypeOfInsurance = "Accident";
    inRepository.save(i1);
    
    InternetBanking ib1 = new InternetBanking();
    ib1.onlinetransaction = oRepository.findByCustomerAccNum(c1.customerAccNum);
    ib1.billPay = bRepository.findByBillNum(bill1.BillNum);
    ib1.insurance = inRepository.findByInsuranceId(i1.insuranceId);
    iRepository.save(ib1);
    
    com.example.bankingApplication.serviceRequest.Service s1 = new com.example.bankingApplication.serviceRequest.Service();
    s1.loanDetails = lRepository.findByLoanNumber(123);
    s1.lockerDetails = lcRepository.findByLockerNum(1);
    s1.iBanking = iRepository.findByOnlineTransaction(ot1);
    
  }
  public Loan getServiceByLoanNumber(int LoanNumber) {
    return lRepository.findByLoanNumber(LoanNumber);
  }
  
  public com.example.bankingApplication.serviceRequest.Service insertService(com.example.bankingApplication.serviceRequest.Service service) {
    lcRepository.save(service.lockerDetails);
    lRepository.save(service.loanDetails);
    bRepository.save(service.iBanking.billPay);
    oRepository.save(service.iBanking.onlinetransaction);
    inRepository.save(service.iBanking.insurance);
    iRepository.save(service.iBanking);
    return repository.save(service);
  }
}
