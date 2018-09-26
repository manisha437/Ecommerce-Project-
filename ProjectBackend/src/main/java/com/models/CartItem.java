package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int cartItemId;
	@ManyToOne
private Product product;
	@ManyToOne
private User user;
private int quantity;
private int Price;

private double totalPrice;

public int getCartItemId() {
	return cartItemId;
}

public void setCartItemId(int cartItemId) {
	this.cartItemId = cartItemId;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getPrice() {
	return Price;
}

public void setPrice(int price) {
	Price = price;
}

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}


}


