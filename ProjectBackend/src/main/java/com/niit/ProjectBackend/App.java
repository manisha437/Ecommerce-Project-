package com.niit.ProjectBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.configuration.DbConfiguration;
import com.dao.CartItemDao;
import com.dao.CartItemDaoImpl;
import com.dao.CategoryDao;
import com.dao.CategoryDaoImpl;
import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.dao.RegistrationDao;
import com.dao.RegistrationDaoImpl;
import com.models.CartItem;
import com.models.Category;
import com.models.Customer;
import com.models.Product;
import com.models.Registration;


public class App 
{ 	@Autowired
    public static void main( String[] args )
    {
   
        System.out.println( "Hello World!" );
         ApplicationContext context=new AnnotationConfigApplicationContext(DbConfiguration.class,ProductDaoImpl.class,RegistrationDaoImpl.class,CategoryDaoImpl.class,CustomerDaoImpl.class,CartItemDaoImpl.class);
         ProductDao pdao=(ProductDao) context.getBean("productDaoImpl");
         CartItemDao cartdao=(CartItemDao) context.getBean("cartItemDaoImpl");
         
       RegistrationDao rdao=(RegistrationDao) context.getBean("registrationDaoImpl");
        CategoryDao cdao=(CategoryDao) context.getBean("categoryDaoImpl");
        CustomerDao ctdao=(CustomerDao) context.getBean("customerDaoImpl");
        
        Product obj4=new Product();
        Category obj1=new Category();
        Registration obj=new Registration();
       Customer obj2=new Customer();
       CartItem obj5=new CartItem();
        
       
        obj4.setName("Gulabjamun");
        obj4. setPrice(180);
        obj4.setDesc("sugar");
        obj4.setquantity(10);
     pdao.saveProduct(obj4);
        
        
        obj.setFrstname("abc");
        obj.setLastname("yyyy");
        obj.setAddress("pqr");
        obj.setAddress("pyyy");
        rdao.saveRegist(obj);
        
        obj1.setCategoryname("Gulabjamun");
       
        obj1.setCdesc("sugar");
        cdao.saveCategory(obj1);

        obj1.setCategoryname("Gulabjamun");
        obj2. setFirstname("Mani");
    	obj2. setLastname("Ahuja");
    	obj2.setPhonenumber(null);

       // obj5.setCartItem(cartItem);
        //obj5.setCartItemId(cartItemId);
        //obj5.setquantity(quantiy);
        //obj5.serPrice(price);
        //obj5. setTotalPrice(Price * Quantity);
        //cartdao.addToCart(obj5);
        

    }
       
}

