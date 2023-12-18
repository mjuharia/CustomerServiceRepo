package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.FundingSource;

public interface FundingSourceRepository extends JpaRepository<FundingSource, Integer> {

}
