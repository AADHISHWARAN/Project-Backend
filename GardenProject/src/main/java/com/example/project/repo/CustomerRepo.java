package com.example.project.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Customer;




public interface CustomerRepo extends JpaRepository<Customer, Long> {

@SuppressWarnings("unchecked")
Customer save(Customer customer);
}