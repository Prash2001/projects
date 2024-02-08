package com.java.springsecurity.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.java.springdemo.entity.Product;
import com.java.springdemo.entity.User;
import com.java.springdemo.entity.WishList;
import com.java.springdemo.service.ProductService;
import com.java.springdemo.service.UserService;
import com.java.springdemo.service.WishListService;

@Controller
@RequestMapping("/user")
public class UserController {
  User globaluser;
  @Autowired
  private ProductService productService;
  @Autowired
  private UserService userService;
  @Autowired
  private WishListService wishListService;

  @GetMapping("/login")
  public String login(@ModelAttribute("user") User user, Model model) {
    System.out.println("-------->" + user);
    return "login";
  }

  @GetMapping("/showRegistrationForm")
  public String showRegistrationForm(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "user-registration";
  }

  @GetMapping("/validateUser")
  public String validateUser(@RequestParam("txtName") String username,
      @RequestParam("txtPwd") String password, Model model, RedirectAttributes redirectAttributes) {
    User user = userService.getUser(username, password);
    if (user == null) {
      return "failure";
    }
    redirectAttributes.addFlashAttribute("user", user);
    System.out.println(user);
    return "redirect:/product/getProducts";
  }

  @PostMapping("/addUser")
  public String addUser(@ModelAttribute("user") User user) {
    userService.addUser(user);
    return "redirect:/user/login";
  }

  @GetMapping("/myUser") // @RequestParam("user") @Validated String user
  public String myUser(@RequestParam("user") String user, Model model) {
    System.out.println("THsdn fsdfsfsd" + user);
    String[] arr = user.split("=");
    // for(int i=0;i<arr.length;i++) {
    // System.out.println(arr[i]);
    // }
    System.out.println(arr[1].split(",")[0]);
    System.out.println(arr[2].split(",")[0]);
    User theUser = userService.getUser(arr[1].split(",")[0], arr[2].split(",")[0]);
    if (theUser != null) {
      globaluser = theUser;
    }
    System.out.println(theUser);
    model.addAttribute("user", globaluser);
    return "user-details";
  }

  @GetMapping("/addToWishList")
  public String addToWishList(@RequestParam("wishListItem") int id, Model model) {
    System.out.println(id);
    model.addAttribute("productId", id);
    return "add-to-wishlist";
  }

  @GetMapping("/addWishListItem")
  public String addWishListItem(@RequestParam("productId") int id, Model model) {
    System.out.println("Here also Id-->"+id);
    Product product = productService.getProductById(id);
    System.out.println("This is product we are adding -->"+product);
    globaluser.addProduct(product);
    productService.saveProduct(product);
    List<WishList> items = wishListService.getWishListItems(globaluser.getUsername());
    List<Product> myWishListItems = new ArrayList<>();
    for(WishList item : items) {
      myWishListItems.add(productService.getProductById(item.getProductId()));
    }
    System.out.println("My WishList -->"+myWishListItems);
    model.addAttribute("products", myWishListItems);
    return "my_wish_list";
  }
}
