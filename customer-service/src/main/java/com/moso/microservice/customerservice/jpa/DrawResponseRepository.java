package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.DrawResponse;

public interface DrawResponseRepository extends JpaRepository<DrawResponse, Integer> {

}
