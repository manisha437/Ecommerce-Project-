package com.models;

import java.beans.Transient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	//@NotEmpty(message="Productname cannot be empty")
	private int price;
	//@Min(value=1,message="Minimum value for price is 1")
	private String desc;
	//@NotEmpty(message="productdescription is mandatory")
	private int quantity;
	//@Min(value=0,message="Quantity cannot be less than 0")//user cannot give -ve values for quantity
	
	//@OneToMany(mappedBy="Product")
	
//@Transient

private transient MultipartFile image;
	
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getquantity() {
		return quantity;
	}
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	
	}

