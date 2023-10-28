package com.example.bankingApplication;
import com.example.bankingApplication.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.example.bankingApplication.*")
@ComponentScan("com.example.bankingApplication.repository.CustomerRepository")
@ComponentScan(basePackageClasses = CustomerController.class)
@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

}
