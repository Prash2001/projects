package com.java.sprigdemo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentsController {
@RequestMapping("/showForm")
public String showForm(Model model) {
  Student student = new Student();
  model.addAttribute("student",student);
  return "student-form";
}
@RequestMapping("/processForm")
public String processForm(@ModelAttribute("student") Student student) {
System.out.println(student.getFirstName()+" "+student.getLastName());
System.out.println(student.getData());
//student.setImage(Base64.getEncoder().encodeToString(student.getData()));
//System.out.println("===============>"+student.getImage());
//student.setData(student.getBlob().getBytes(1, (int) student.getBlob().length()));
  return "student-confirmation";
}
}
