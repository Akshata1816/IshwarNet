package com.akshata.service.customer;

import java.util.*;

import com.akshata.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.akshata.entity.Customer;
import com.akshata.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer updatCustomer(Customer customer) {
		Customer oldCustomer = getCustomer(customer.getCustomer_id());

		if (customer.getCustomer_name() != null && !customer.getCustomer_name().isEmpty() && !customer.getCustomer_name().equals(oldCustomer.getCustomer_name())) {
			oldCustomer.setCustomer_name(customer.getCustomer_name());
		}

		if (customer.getUsername() != null && !customer.getUsername().isEmpty() && !customer.getUsername().equals(oldCustomer.getUsername())) {
			oldCustomer.setUsername(customer.getUsername());
		}

		if (customer.getMob_number() != null && !customer.getMob_number().equals(oldCustomer.getMob_number())) {
			oldCustomer.setMob_number(customer.getMob_number());
		}

		if (customer.getAlt_mob_number() != null && !customer.getAlt_mob_number().equals(oldCustomer.getAlt_mob_number())) {
			oldCustomer.setAlt_mob_number(customer.getAlt_mob_number());
		}

		if (customer.getAddress() != null && !customer.getAddress().isEmpty() && !customer.getAddress().equals(oldCustomer.getAddress())) {
			oldCustomer.setAddress(customer.getAddress());
		}

		if (customer.getCity() != null && !customer.getCity().isEmpty() && !customer.getCity().equals(oldCustomer.getCity())) {
			oldCustomer.setAddress(customer.getCity());
		}

		if (customer.getPincode() != null && !customer.getPincode().isEmpty() && !customer.getPincode().equals(oldCustomer.getPincode())) {
			oldCustomer.setAddress(customer.getPincode());
		}

		if (customer.getPackageType() != null && customer.getPackageType().getPredefinedId() != null && (oldCustomer.getPackageType() == null || !customer.getPackageType().getPredefinedId().equals(oldCustomer.getPackageType().getPredefinedId()))) {
			oldCustomer.setPackageType(customer.getPackageType());
		}
		oldCustomer.setLastModifieDate(new Date());

		return this.customerRepository.save(oldCustomer);
	}

	@Override
	public Customer getCustomer(long c_id) {
		Optional<Customer> customer = this.customerRepository.findById(c_id);
		if (customer.isPresent()) {
			return customer.get();
		};
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		// Define sorting criteria
//		Sort sortByDesc = Sort.by(Sort.Direction.DESC, "customer_id"); // Replace "fieldName" with the actual field you want to sort by

		return new ArrayList<>(this.customerRepository.findAll());
	}

	@Override
	public void deleteCustomer(long c_id) {
		this.customerRepository.deleteById(c_id);
		
	}

}
