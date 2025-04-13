package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class LoginService {
	UserRepository userRepo;
	
	
	
	public LoginService(UserRepository userRepo) {
		
		this.userRepo = userRepo;
	}



	public boolean validateUser(String username, String password) {
		User user = userRepo.findByUsername(username);
		if(user != null && password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	
}
