package com.java.springsecurity.demo.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{
// Add reference to our security data source
  
  @Autowired
  private DataSource securityDataSource;
  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    // use jdbc auth
    auth.jdbcAuthentication().dataSource(securityDataSource);
  }
//  @Override
//  public void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication().withUser("john").roles("EMPLOYEE").password("{noop}test123");
//;
//    auth.inMemoryAuthentication().withUser("mary").roles("MANAGER").password("{noop}test123");
//;
//    auth.inMemoryAuthentication().withUser("susan").roles("ADMIN").password("{noop}test123");
//;
//  }
//  
  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll();
  }
}
