package com.akshata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshata.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
