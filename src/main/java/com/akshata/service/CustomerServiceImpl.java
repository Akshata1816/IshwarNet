package com.akshata.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshata.entity.Customer;
import com.akshata.repository.CustomerRepository;

import net.bytebuddy.asm.Advice.This;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer updatCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(long c_id) {
		return this.customerRepository.findById(c_id).get();
	}

	@Override
	public Set<Customer> getCustomers() {
		return new HashSet<>(this.customerRepository.findAll());
	}

	@Override
	public void deleteCustomer(long c_id) {
		this.customerRepository.deleteById(c_id);
		
	}

}
