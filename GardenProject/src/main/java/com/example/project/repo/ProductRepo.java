package com.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Products;




public interface ProductRepo extends JpaRepository<Products, Long> {

	@SuppressWarnings("unchecked")
	Products save(Products u);
}