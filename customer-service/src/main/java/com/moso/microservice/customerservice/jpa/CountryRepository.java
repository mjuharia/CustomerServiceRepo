package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.Country;



public interface CountryRepository extends JpaRepository<Country, Integer> {

}
