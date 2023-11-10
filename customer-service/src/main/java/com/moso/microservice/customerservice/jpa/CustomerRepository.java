package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
