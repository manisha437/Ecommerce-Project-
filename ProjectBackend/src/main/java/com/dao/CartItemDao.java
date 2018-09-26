package com.dao;

import java.util.List;

import com.models.CartItem;
import com.models.CustomerOrder;
import com.models.User;

public interface CartItemDao {
void addToCart(CartItem cartItem);
User getUser(String email);
List<CartItem>  getCart(String email);//select * from cartitem where user_email=?
void removeCartItem(int cartItemId);
CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}

