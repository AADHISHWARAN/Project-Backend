package com.example.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Products;
import com.example.project.repo.ProductRepo;



@Service
public class ProductService {

	@Autowired
	ProductRepo
	urepo;

	// post
	public Products saveProducts(Products u) {
		return urepo.save(u);
	}

	// get
	public List<Products> getProducts() {
		return urepo.findAll();
	}

	// get the data using id
	public Products getProductId(Long id) {
		return urepo.findById(id).orElse(null);
	}

	// put or update
	public Products updateProducts(Products u, Long id) {
		Products prod = urepo.findById(id).orElse(null);
		if (prod != null) {
			prod.setProductName(u.getProductName());
			return urepo.saveAndFlush(u);
		} else {
			return null;
		}

	}

	// detele
	public void deleteProducts(long id) {
		urepo.deleteById(id);
	}


}

