package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.Authorities;
import com.models.Customer;
@Service
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		   
		   //SET ENABLED property in USER as true
		   customer.getUser().setEnabled(true);
		   
		   System.out.println(customer.getUser().getAuthorities());
		   
		   //CREATE new AUTHORITIES OBJECT AND SET THE ROLE AS ROLE_USER
		   Authorities authorities=new Authorities();
		   authorities.setRole("ROLE_USER");
		   //AUTHORITIES PROPERTY IN USER REFERS TO AUTHORITIES OBJECT
		   customer.getUser().setAuthorities(authorities);
		   
		   //MAKE USER PROPERTY IN AUTHORITIES TO REFER USER OBJECT
		   authorities.setUser(customer.getUser());
		   
		   
		   session.save(customer);
		   //has to insert into customer table
		
	}
	//public void saveCustomer(Customer obj2) {
		// TODO Auto-generated method stub
		
	//}
}
//	public void saveCustomer(Customer obj2) {
//		Session session=sessionFactory.getCurrentSession();
//		System.out.println("Id of the product before persisting " + obj2.getId());
//    	session.save(obj2); 
//    	System.out.println("Id of the product after persisting " + obj2.getId());
//    	 
//	}
//	}
