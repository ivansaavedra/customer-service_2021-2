package com.dws.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dws.customerservice.Repository.CustomerRepository;
import com.dws.customerservice.dto.Customer;
import com.dws.customerservice.dto.RespuestaApi;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.getCustomers();
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomer(id);
	}

	@Override
	public RespuestaApi createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.createCustomer(customer);
	}

	@Override
	public RespuestaApi updateCustomer(Customer customer, int id) {
		// TODO Auto-generated method stub
		return customerRepository.updateCustomer(customer, id);
	}

	@Override
	public RespuestaApi deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return customerRepository.deleteCustomer(id);
	}

}
