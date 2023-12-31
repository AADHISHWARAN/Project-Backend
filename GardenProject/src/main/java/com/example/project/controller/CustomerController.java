package com.example.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Customer;

import com.example.project.service.CustomerService;




@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomer();
	}
	@GetMapping("/{id}")
	public Customer getCustomerID(@PathVariable Long id) {
		return customerService.getCustomerid(id);
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer ,@PathVariable Long id) {

		return customerService.updateCustomer(customer,id);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}

}