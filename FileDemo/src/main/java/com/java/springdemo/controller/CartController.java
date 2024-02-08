package com.java.springdemo.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.java.springdemo.entity.Cart;
import com.java.springdemo.entity.CartItem;
import com.java.springdemo.entity.Product;
import com.java.springdemo.entity.User;
import com.java.springdemo.service.CartItemService;
import com.java.springdemo.service.CartService;
import com.java.springdemo.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
  
  @GetMapping("/addToCart")
public String addToCart(@RequestParam("cartItem") int id, Model model, HttpSession session) {
  return "doc";
}
}
  