package com.springmvc.crud.dao.intface;

import java.util.List;

import com.springmvc.crud.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
}
