package com.springmvc.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.crud.entity.Customer;
import com.springmvc.crud.intface.CustomerDAOtwo;
import com.springmvc.crud.intface.CustomerServicetwo;



@Service // tell spring that this is a service
public class CustomerServiceImpltwo implements CustomerServicetwo {
	
	@Autowired
	private CustomerDAOtwo customerDAO;
	
	@Override
	public List<Customer> getCustomerList() {
		return customerDAO.getCustomers();
	}
	
	@Override
	public void saveCustomers(Customer customer) {
		customerDAO.saveCustomers(customer);
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Customer customer = customerDAO.getCustomerById(customerId);
		return customer;
	}

	@Override
	public void deleteById(Integer customerId) {
		customerDAO.deleteById(customerId);
	}

}

