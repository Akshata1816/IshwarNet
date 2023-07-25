package com.akshata.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshata.entity.Customer;
import com.akshata.service.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(this.customerService.addCustomer(customer));
	}
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return this.customerService.updatCustomer(customer);
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable long c_id) {
		return this.customerService.getCustomer(c_id);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Set<Customer>> getCustomers() {
		return ResponseEntity.ok(this.customerService.getCustomers());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable long c_id) {
		this.customerService.deleteCustomer(c_id);
	}

}
