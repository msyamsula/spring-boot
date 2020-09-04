package com.springmvc.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.crud.entity.Customer;
import com.springmvc.crud.intface.CustomerServicetwo;


@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerServicetwo customerService;
	
	@GetMapping("/list")
	public String getCustomerList(Model model) {
		// get customer list from dao
		List<Customer> customers = customerService.getCustomerList();
		
		// add list to the page
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showAddForm")
	public String showForm(Model model) {
		Customer newCustomer = new Customer();
		model.addAttribute("customer", newCustomer);
		return "add-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCostumer) {
		customerService.saveCustomers(theCostumer);
		return "redirect:/customers/list";
	}
	
	@GetMapping("/update")
	public String updateCustomers(@RequestParam("customerId") Integer customerId, Model model) {
		System.out.println(customerId);
		Customer customer = customerService.getCustomerById(customerId);
		model.addAttribute("customer", customer);
		return "add-form";
	}
	
	@GetMapping("/delete/{customerId}")
	public String deleteCustomers(@PathVariable Integer customerId) {
		System.out.println(customerId);
		customerService.deleteById(customerId);
		return "redirect:/customers/list";
	}
}
