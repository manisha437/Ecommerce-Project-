package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.Registration;

@Repository
@Transactional

public class RegistrationDaoImpl implements RegistrationDao
{
	@Autowired
	
	private SessionFactory sessionFactory;	

	public Registration saveRegist(Registration reg) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Id of the registered user before persisting" + reg.getId());
		session.save(reg);
		System.out.println("Id of the registered user after persisting" + reg.getId());
		return reg;
	}

	public Registration updateRegist(Registration reg) {
		Session session=sessionFactory.getCurrentSession();
		session.update(reg);
		return reg;
	}

	public Registration getRegist(int id) {
		Session session=sessionFactory.getCurrentSession();
		Registration reg=(Registration) session.get(Registration.class, id);
		return reg;
	}

	public Registration deleteRegist(Registration reg) {
		Session session=sessionFactory.getCurrentSession();
		 session.delete(reg);
		 return reg;
	}

	public List<Registration> getAllRegist() {
		Session session=sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Registration");//Registration is an entity 
		List<Registration> regs=(List) query.list();
		for(Registration r:regs)
		{
			System.out.println(r.getLastname());
		}
		return (java.util.List<Registration>) regs;
		
	}
	



}
