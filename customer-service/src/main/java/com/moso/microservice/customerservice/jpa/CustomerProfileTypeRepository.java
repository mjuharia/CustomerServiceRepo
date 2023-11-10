package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.CustomerProfileType;

public interface CustomerProfileTypeRepository extends JpaRepository<CustomerProfileType, Integer> {

}
