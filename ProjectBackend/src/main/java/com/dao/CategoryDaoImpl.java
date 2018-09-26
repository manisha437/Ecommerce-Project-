package com.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.models.Category;
import com.models.Customer;

@Repository
@Transactional
public class CategoryDaoImpl  implements CategoryDao
{
	@Autowired
	private SessionFactory sessionFactory;
	public Category saveCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Id of the registered user before persisting" + category.getId());
		session.save(category);
		System.out.println("Id of the registered user after persisting" + category.getId());
		return category;
	}


	public Category updateCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		session.update(category);
		return category;
	}

	
	public Category getCategory(int id) {
		Session session=sessionFactory.getCurrentSession();
		Category category=(Category) session.get(Category.class, id);
		return category;
	}

	
	public Category deleteCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		 session.delete(category);
		 return category;
	}


	public List<Category> getAllCategory() {
		Session session=sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Category");//Registration is an entity 
		List<Category> categories=(List) query.list();
		
		return  categories;	
	}


	public void saveCustomer(Customer obj2) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Id of the registered user before persisting" + obj2.getId());
		session.save(obj2);
		System.out.println("Id of the registered user after persisting" + obj2.getId());
		
	}

	
}