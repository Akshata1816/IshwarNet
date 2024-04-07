package com.akshata.service.customer;

import java.util.List;
import java.util.Set;

import com.akshata.entity.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer updatCustomer(Customer customer);
	
	public Customer getCustomer(long c_id);
	
	public List<Customer> getCustomers();
	
	public void deleteCustomer(long c_id);

}
