package com.dws.customerservice.service;

import java.util.List;

import com.dws.customerservice.dto.Customer;
import com.dws.customerservice.dto.RespuestaApi;

public interface CustomerService {

	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public RespuestaApi createCustomer(Customer customer);
	public RespuestaApi updateCustomer(Customer customer, int id);
	public RespuestaApi deleteCustomer(int id);
}
