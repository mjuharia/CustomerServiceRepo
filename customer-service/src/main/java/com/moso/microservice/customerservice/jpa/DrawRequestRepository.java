package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.DrawRequest;

public interface DrawRequestRepository extends JpaRepository<DrawRequest, Integer>{

}
