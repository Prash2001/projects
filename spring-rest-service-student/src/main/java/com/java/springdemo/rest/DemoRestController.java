package com.java.springdemo.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.springdemo.entity.Student;
import com.java.springdemo.entity.StudentErrorResponse;
import com.java.springdemo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class DemoRestController {
  
  
@GetMapping("/getStudents")
public List<Student> getStudents() {
  List<Student> students = new ArrayList<>();
  students.add(new Student("Luffy", "Monkey"));
  students.add(new Student("Zoro", "Roronoa"));
  return  students;
}   

@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
  StudentErrorResponse error = new StudentErrorResponse();
  error.setStatus(HttpStatus.NOT_FOUND.value());
  error.setMessage(exc.getMessage());
  error.setTimeStamp(System.currentTimeMillis());
  return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  
}
@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
  StudentErrorResponse error = new StudentErrorResponse();
  error.setStatus(HttpStatus.BAD_REQUEST.value());
  error.setMessage(exc.getMessage());
  error.setTimeStamp(System.currentTimeMillis());
  return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  
}
@GetMapping("/getStudent/{studentId}")
public Student getStudent(@PathVariable int studentId) {
  List<Student> students = new ArrayList<>();
  students.add(new Student("Luffy", "Monkey"));
  students.add(new Student("Zoro", "Roronoa"));
  if(studentId>=students.size() || studentId<0) {
    throw new StudentNotFoundException("Student id not found - "+studentId);
  }
  return  students.get(studentId);
}  
}