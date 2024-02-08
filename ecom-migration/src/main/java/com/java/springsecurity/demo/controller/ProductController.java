package com.java.springsecurity.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.java.springdemo.entity.FileModel;
import com.java.springdemo.entity.Product;
import com.java.springdemo.entity.User;
import com.java.springdemo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/showAddProductForm")
  public String showAddProductForm(Model model) {
    // Product product = new Product();
    // model.addAttribute("product", product);
    Product product;
    if (!model.containsAttribute("product")) {
      product = new Product();
      model.addAttribute("product", product);
    }
    return "add-product";
  }

  @PostMapping("/saveProduct")
  public String saveProduct(@ModelAttribute("product") Product product) {
    productService.saveProduct(product);
    return "redirect:/product/showAddProductForm";
  }

  @GetMapping("/getProducts")
  public String getProducts(@ModelAttribute("user") @Validated User user, Model model,
      RedirectAttributes redirectAttributes) {
    List<Product> theProducts = productService.getProducts();
    if (theProducts.size() > 0) {
      System.out.println(theProducts.size());
      model.addAttribute("products", theProducts);
      System.out.println("---->---->--->" + user);
      User theUser = user;
      model.addAttribute(theUser);
      redirectAttributes.addFlashAttribute("user", theUser);
    }
    return "index";
  }

  @GetMapping("/getProductById")
  public String getProductById(@ModelAttribute("id") @Validated int id, Model model,
      RedirectAttributes redirectAttributes) {
    Product theProduct = productService.getProductById(id);
    if (theProduct != null) {
      System.out.println(theProduct);
      model.addAttribute("product", theProduct);
      redirectAttributes.addFlashAttribute("product", theProduct);
    }
    return "redirect:/user/addWishListItem";
  }

  @Autowired
  ServletContext context;

  @GetMapping("/fileUploadPage")
  public ModelAndView fileUploadPage(Model model) {
    // FileModel file = new FileModel();
    // model.addAttribute("product", product);
    FileModel file = new FileModel();
    ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
    return modelAndView;
    // return "fileUpload";//modelAndView;
  }

  @PostMapping("/fileUploadPage")
  public String fileUpload(@Validated FileModel file, BindingResult result, Model model)
      throws IOException {
    if (result.hasErrors()) {
      System.out.println("validation errors");
      return "fileUploadPage";
    } else {
      System.out.println("Fetching file");
      MultipartFile multipartFile = file.getFile();
      String uploadPath =
          "C:\\Users\\prashantjapkar\\eclipse-workspace\\ecom-demo-01\\WebContent\\resources\\img\\";
      // Now do something with file...
      FileCopyUtils.copy(file.getFile().getBytes(),
          new File(uploadPath + file.getFile().getOriginalFilename()));
      String fileName = multipartFile.getOriginalFilename();
      Product product = new Product();
      // Product product = (Product) model.getAttribute("product");
      product.setImageName(fileName);
      System.out.println(product.getImageName());
      model.addAttribute("product", product);
      return "add-product";// "redirect:/product/showAddProductForm";
    }
  }

  @GetMapping("/addToWishList")
  public String addToWishList(Model model) {
    return "wishlist";
  }

}
