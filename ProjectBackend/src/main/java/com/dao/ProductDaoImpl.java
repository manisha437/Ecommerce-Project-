package com.dao;
import java.util.*;
import java.util.Locale.Category;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.models.Product;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;	

	public Product saveProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Id of the product before persisting " + product.getId());
    	session.save(product); 
    	System.out.println("Id of the product after persisting " + product.getId());
    	return product; 
	}
	 public Product updateProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
		return product;
		
	}
	
	public Product getProduct(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product) session.get(Product.class, id);
		return product;
		
	}

	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Product");//Product is an entity 
		List<Product> products=(List) query.list();
		for(Product p:products)
		{
			System.out.println(p.getName());
		}
		return (java.util.List<Product>) products;
		
	}
	public List<Category> getAllCategories() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		List<Category> categories=query.list();
		return categories;
	}
	public void deleteProduct(int id) {
	
		Session session=sessionFactory.getCurrentSession();
		//Get product object for the given id
		Product product=(Product)session.get(Product.class, id);
		if(product!=null)
		session.delete(product);//delete from product where id=?
		
	}
		
	
	
	}

