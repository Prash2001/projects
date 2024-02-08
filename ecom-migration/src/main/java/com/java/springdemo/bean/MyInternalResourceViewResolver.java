//package com.java.springdemo.bean;
//
//import java.beans.PropertyVetoException;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.SessionFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
//public class MyInternalResourceViewResolver {
//
//  @Bean
//  public ViewResolver viewResolver() {
//    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//    viewResolver.setPrefix("/WEB-INF/view/");
//    viewResolver.setSuffix(".jsp");
//    return viewResolver;
//  }
//
//  @Bean(name = "myDataSource")
//  public ComboPooledDataSource myDataSource() {
//    ComboPooledDataSource cpds = new ComboPooledDataSource();
//    try {
//      cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
//      cpds.setJdbcUrl("jdbc:mysql://localhost:3306/web_ecom-app?useSSL=false&amp;serverTimezone=UTC");
//      cpds.setUser("springstudent");
//      cpds.setPassword("springstudent");
//      cpds.setMinPoolSize(5);
//      cpds.setMaxPoolSize(20);
//      cpds.setMaxIdleTime(30000);
//      return cpds;
//    } catch (PropertyVetoException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//    finally {
//      cpds.close();
//    }
//  }
//  
//  @Bean(name = "sessionFactory")
//  public SessionFactory sessionFactory() {
//    SessionFactoryBuilder sessionFactoryBuilder = new SessionFac
//  }
//}
