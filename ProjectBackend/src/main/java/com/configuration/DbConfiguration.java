package com.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.models.Authorities;
import com.models.BillingAddress;
import com.models.CartItem;
import com.models.Category;
import com.models.Customer;
import com.models.CustomerOrder;
import com.models.Product;
import com.models.Registration;
import com.models.ShippingAddress;
import com.models.User;

@SuppressWarnings("deprecation")
@Configuration
@EnableTransactionManagement   
	public class DbConfiguration {
	//to create beans
		
		@Bean(name="dataSource")
		public DataSource getDataSource() {
			System.out.println("Entering DataSource Bean creation method ");
		    BasicDataSource dataSource = new BasicDataSource();
		    dataSource.setDriverClassName("org.h2.Driver");
		    dataSource.setUrl("jdbc:h2:~/test");
		    dataSource.setUsername("sa");
		    dataSource.setPassword("sa");
		    System.out.println("DataSource bean " +dataSource);
		    return dataSource;
		}
		/*
		 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
		 * <property name="dataSource" ref="dataSource">
		 */
		@Bean //SessionFactory - factory of session objects
		public SessionFactory sessionFactory() {
			System.out.println("Entering sessionFactory creation method");
			LocalSessionFactoryBuilder lsf=
					new LocalSessionFactoryBuilder(getDataSource());
			Properties hibernateProperties=new Properties();
			hibernateProperties.setProperty(
					"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
			hibernateProperties.setProperty("hibernate.show_sql", "true");
			lsf.addProperties(hibernateProperties);
			//An array of Class objects of all the entities
			//Map all entities to relational table
			Class classes[]=new Class[]{Product.class,Registration.class,Category.class,Authorities.class,BillingAddress.class,User.class,Customer.class,ShippingAddress.class,CartItem.class,CustomerOrder.class}; //If product class is not yet created, remove this and add it later
			//localsesionfactorybuilder -> sessionfactory -> map all entities with relation table
			System.out.println("SessionFactory bean " + lsf);
		    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
		}
		@Bean
		public HibernateTransactionManager hibTransManagement(){
			return new HibernateTransactionManager(sessionFactory());
		}
	}


