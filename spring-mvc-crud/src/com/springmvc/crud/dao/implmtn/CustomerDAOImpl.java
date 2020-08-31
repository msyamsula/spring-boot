package com.springmvc.crud.dao.implmtn;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.crud.dao.intface.CustomerDAO;
import com.springmvc.crud.entity.Customer;

@Repository // tell spring that this is dao implementation
public class CustomerDAOImpl implements CustomerDAO {
	
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

}
