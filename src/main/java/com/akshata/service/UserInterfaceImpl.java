package com.akshata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshata.entity.User;
import com.akshata.repository.UserRepository;

@Service
public class UserInterfaceImpl implements UserInterface{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(int id) {
		Optional<User> findById = userRepository.findById(id);
		return findById.isPresent()?findById.get():null;
		
	}

}
