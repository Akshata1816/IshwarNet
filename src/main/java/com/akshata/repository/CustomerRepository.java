package com.akshata.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.akshata.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    List<Customer> findAll(Sort sort);
}
