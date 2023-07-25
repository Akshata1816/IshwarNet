package com.akshata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshata.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
}
