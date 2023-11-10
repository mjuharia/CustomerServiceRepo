package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.CustomerContact;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Integer> {

}
