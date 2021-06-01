package com.dws.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dws.customerservice.dto.Customer;
import com.dws.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
	@GetMapping
	public ResponseEntity<Object> getCustomers(){
		return new ResponseEntity<>(customerservice.getCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable("id") int id){
		return new ResponseEntity<>(customerservice.getCustomer(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer){
		return new ResponseEntity<>(customerservice.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
		return new ResponseEntity<>(customerservice.updateCustomer(customer, id), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id){
		return new ResponseEntity<>(customerservice.deleteCustomer(id), HttpStatus.OK);
	}
}
