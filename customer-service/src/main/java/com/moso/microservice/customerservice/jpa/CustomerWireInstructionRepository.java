package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.CustomerWireInstruction;

public interface CustomerWireInstructionRepository extends JpaRepository<CustomerWireInstruction, Integer> {

}
