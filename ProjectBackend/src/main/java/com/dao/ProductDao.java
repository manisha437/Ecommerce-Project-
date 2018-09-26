package com.dao;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.ui.Model;

import com.models.Product;



public interface ProductDao
{
	Product saveProduct(Product product);
	Product updateProduct(Product product);
	Product getProduct(int id);
	void deleteProduct(int id);
		List<Product> getAllProducts();//fetch all the records from product table
	List<Category> getAllCategories();
	
}
