package com.springmvc.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.crud.dao.intface.CustomerDAO;
import com.springmvc.crud.entity.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	@Qualifier("customerDAOImpl")
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String getCustomerList(Model model) {
		// get customer list from dao
		List<Customer> customers = customerDAO.getCustomers();
		
		// add list to the page
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
