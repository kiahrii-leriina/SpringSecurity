package com.kl.springSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kl.springSecurity.model.Users;
import com.kl.springSecurity.service.UserService;

@RestController
public class UserController {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return service.getUsers();
	}
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return service.registerUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		return service.verify(user);
	}

}
