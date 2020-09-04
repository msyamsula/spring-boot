package com.springmvc.crud.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.crud.entity.Customer;
import com.springmvc.crud.intface.CustomerDAOtwo;


@Repository // tell spring that this is dao implementation
public class CustomerDAOImpltwo implements CustomerDAOtwo {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional // use predefined begin and commit transaction, no need to explicitly type begin and commit
	public List<Customer> getCustomers() {
		
		// get current session
		Session session = sessionFactory.getCurrentSession();
		
		// execute query
		List<Customer> customers = session.createQuery("from Customer").getResultList();
		
		// return the list
		return customers;
		
	}
	
	@Override
	@Transactional
	public void saveCustomers(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomerById(Integer customerId) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, customerId);
		System.out.println(customer.toString());
		return customer;
	}

	@Override
	@Transactional
	public void deleteById(Integer customerId) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "delete Customer c where c.id = " + customerId;
		session.createQuery(hql).executeUpdate();
	}

}
