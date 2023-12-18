package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moso.microservice.customerservice.enity.Error;

public interface ErrorRepository extends JpaRepository<Error, Integer> {

}
