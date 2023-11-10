package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.CustomerProfile;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Integer> {

}
