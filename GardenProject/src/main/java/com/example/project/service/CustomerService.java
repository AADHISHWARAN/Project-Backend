package com.example.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Customer;
import com.example.project.repo.CustomerRepo;




@Service
public class CustomerService {

	@Autowired
	CustomerRepo custRepo;

	// post the data
	public Customer saveCustomer(Customer customer) {
		return custRepo.save(customer);
	}

	// get the data
	public List<Customer> getAllCustomer() {
		return custRepo.findAll();
	}
	
	// get the data using id
	public Customer getCustomerid(Long id) {
		return custRepo.findById(id).orElse(null);
	}
	// update the data
	public Customer updateCustomer(Customer customer, Long id) {
		Customer customerx = custRepo.findById(id).orElse(null);
				if(customerx !=null) {
					customerx.setCustomerName(customer.getCustomerName());
					customerx.setProducts(customer.getProducts());
						return custRepo.saveAndFlush(customerx);
				}
				else {
					return null;
				}
	}

	// delete the data
	public void deleteCustomer(Long id) {
		custRepo.deleteById(id);
	}

}
