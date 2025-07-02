package com.kl.springSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kl.springSecurity.model.Users;
import com.kl.springSecurity.repo.UserRepo;

@Service

public class UserService {
	
	@Autowired
	private UserRepo repo;
	

	public Users registerUser(Users user) {
		return repo.save(user);
	}


	public List<Users> getUsers() {
		return repo.findAll();
	}
	


}
