package com.example.project.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.SignUp;



public interface SignUpRepo extends JpaRepository<SignUp, Long>{

	SignUp findByEmail(String email);

	
}