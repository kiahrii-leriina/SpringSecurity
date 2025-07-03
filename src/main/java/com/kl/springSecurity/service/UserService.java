package com.kl.springSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.kl.springSecurity.model.Users;
import com.kl.springSecurity.repo.UserRepo;

@Service

public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authmanager;
	

	public Users registerUser(Users user) {
		return repo.save(user);
	}


	public List<Users> getUsers() {
		return repo.findAll();
	}


	public String verify(Users user) {
		Authentication authentication = 
				authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getName());
		}
		return "fail";
		
		
		
		
	}
	


}
