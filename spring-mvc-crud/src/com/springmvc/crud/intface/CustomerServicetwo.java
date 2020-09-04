package com.springmvc.crud.intface;

import java.util.List;

import com.springmvc.crud.entity.Customer;

public interface CustomerServicetwo {
	public List<Customer> getCustomerList();
	public void saveCustomers(Customer constumer);
	public Customer getCustomerById(Integer customerId);
	public void deleteById(Integer customerId);
}
