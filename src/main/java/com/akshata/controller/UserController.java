package com.akshata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshata.entity.User;
import com.akshata.service.UserInterface;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserInterface userInterface;

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		
		return userInterface.getUser(id);
		
	}
}
