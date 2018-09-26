package com.dao;

import java.util.List;

import com.models.Category;
import com.models.Customer;

public interface CategoryDao {

	Category saveCategory(Category category);
	Category updateCategory(Category category);
	Category getCategory(int id);
		Category deleteCategory(Category category);
	List<Category> getAllCategory();//fetch all the records from category table
	void saveCustomer(Customer obj2);
	
}
