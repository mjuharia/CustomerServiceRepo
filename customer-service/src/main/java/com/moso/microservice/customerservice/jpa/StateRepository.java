package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.State;

public interface StateRepository extends JpaRepository<State, Integer> {

}
