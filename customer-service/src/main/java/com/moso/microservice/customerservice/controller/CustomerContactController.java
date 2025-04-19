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
import com.moso.microservice.customerservice.enity.CustomerContact;
import com.moso.microservice.customerservice.exceptions.CustomerContactNotFoundException;
import com.moso.microservice.customerservice.exceptions.CustomerNotFoundException;
import com.moso.microservice.customerservice.jpa.CustomerContactRepository;
import com.moso.microservice.customerservice.jpa.CustomerRepository;

import jakarta.validation.Valid;

@RestController
public class CustomerContactController {
	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	CustomerContactRepository contactRepo;
	
	
	
	/**** BEGIN CUSTOMER CONTACT REST CALL ****/
	
	@GetMapping("/contacts")
	public List<CustomerContact> findAllContacts(){
		return contactRepo.findAll();
	}
	
	@GetMapping("/contacts/{id}")
	public CustomerContact findContactByID(@PathVariable int id){
		
		Optional<CustomerContact> lOptContact = contactRepo.findById(id);
		
		if (lOptContact.isEmpty()) {
			throw new CustomerContactNotFoundException("Customer Contact Id = " + id + " NOT FOUND!");
		}
		
		CustomerContact lContact = lOptContact.get();
		
		return lContact;
	}
	
	@GetMapping("/customers/{id}/contacts")
	public List<CustomerContact> findAllCustomerContacts(@PathVariable int id){
		//return custRepo.findAll();
		
		Optional<Customer> lOptCust = custRepo.findById(id);
		
		if (lOptCust.isEmpty()) {
			throw new CustomerNotFoundException("Customer Id = " + id + " NOT FOUND!");
		}
		
		Customer lCust = lOptCust.get();
		
		return lCust.getCustContacts();
		
	}
	
	@GetMapping("/customers/{cust_id}/contacts/{contact_id}")
	public EntityModel<CustomerContact> findCustomerContactById(@PathVariable int cust_id, @PathVariable int contact_id){
		Optional<Customer> lOptCust = custRepo.findById(cust_id);
		
		if (lOptCust.isEmpty()) {
			throw new CustomerNotFoundException("Customer Id = " + cust_id + " NOT FOUND!");
		}
		
		Customer lCust = lOptCust.get();
		EntityModel<CustomerContact> lEntCustContact;
		
		List<CustomerContact> custConacts = lCust.getCustContacts();
		
		for(CustomerContact contact : custConacts) {
			if (contact.getId().equals(contact_id)){
				lEntCustContact = EntityModel.of(contact);
				WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllCustomerContacts(cust_id));
				lEntCustContact.add(link.withRel("all-customer-contacts"));
				return lEntCustContact;
			}
		}
			
				
		return null;
		
	}
	
	@PostMapping("/customers/{cust_id}/contacts")
	public ResponseEntity<Customer> createCustomerContact(@PathVariable int cust_id, @Valid @RequestBody CustomerContact contact){
		
		Optional<Customer> lOptCust = custRepo.findById(cust_id);
		
		
		if (lOptCust.isEmpty()) {
			throw new CustomerNotFoundException("Customer Id = " + cust_id + " NOT FOUND!");
		}
		
		Customer lCust = lOptCust.get();
		contact.setiCustomer(lCust);
		CustomerContact lcontact = contactRepo.save(contact);
		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(lcontact.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/customers/{cust_id}/contacts")
	public ResponseEntity<Customer> updateCustomerContact(@PathVariable int cust_id, @Valid @RequestBody CustomerContact contact){
		
		Optional<Customer> lOptCust = custRepo.findById(cust_id);
		
		
		if (lOptCust.isEmpty()) {
			throw new CustomerNotFoundException("Customer Id = " + cust_id + " NOT FOUND!");
		}
		
		if (contact.getId() == null || contact.getId() == 0) {
			throw new CustomerContactNotFoundException("Customer Contact Id not available for PUT request");
		}
		
		Customer lCust = lOptCust.get();
		contact.setiCustomer(lCust);
		CustomerContact lcontact = contactRepo.save(contact);
		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(lcontact.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
//	@DeleteMapping(name="/customers/{cust_id}/contacts/{contact_id}")
//	public void deleteContact(@PathVariable int cust_id, @PathVariable int contact_id) {
//		
//		contactRepo.deleteById(contact_id);
//	}
	
	
	
	/**** END CUSTOMER CONTACT REST CALL ****/
	
	
}
