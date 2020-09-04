package com.springmvc.crud.intface;

import java.util.List;

import com.springmvc.crud.entity.Customer;

public interface CustomerDAOtwo {
	public List<Customer> getCustomers();
	public void saveCustomers(Customer costumer);
	public Customer getCustomerById(Integer customerId);
	public void deleteById(Integer customerId);
}

