package com.moso.microservice.customerservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moso.microservice.customerservice.enity.Customer;
import com.moso.microservice.customerservice.exceptions.CustomerNotFoundException;
import com.moso.microservice.customerservice.jpa.CustomerContactRepository;
import com.moso.microservice.customerservice.jpa.CustomerRepository;

import jakarta.validation.Valid;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	CustomerContactRepository contactRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/customers")
	public List<Customer> findAllCustomers(){
		return custRepo.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public EntityModel<Customer> findCustomerById(@PathVariable int id){
		Optional<Customer> lOptCust = custRepo.findById(id);
		
		if (lOptCust.isEmpty()) {
			throw new CustomerNotFoundException("Customer Id = " + id + " NOT FOUND!");
		}
		
		Customer lCust = lOptCust.get();
		
		EntityModel<Customer> lEntCust = EntityModel.of(lCust);
		
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllCustomers());
		lEntCust.add(link.withRel("all-customers"));
		
		return lEntCust;
		
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer cust){
		
		Customer savedCustomer = custRepo.save(cust);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedCustomer.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer cust){
		
		Customer savedCustomer = custRepo.save(cust);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedCustomer.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(name="/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		custRepo.deleteById(id);
	}
	
	
	
	
}
