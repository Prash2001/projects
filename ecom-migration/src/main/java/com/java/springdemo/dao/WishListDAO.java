package com.java.springdemo.dao;

import java.util.List;
import com.java.springdemo.entity.WishList;

public interface WishListDAO {

  List<WishList> getWishListItems(String username);

}
