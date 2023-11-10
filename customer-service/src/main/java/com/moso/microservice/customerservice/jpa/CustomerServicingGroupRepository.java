package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.CustomerServicingGroup;

public interface CustomerServicingGroupRepository extends JpaRepository<CustomerServicingGroup, Integer> {

}
