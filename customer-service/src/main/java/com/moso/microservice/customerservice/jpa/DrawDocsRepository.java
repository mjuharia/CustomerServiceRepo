package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.DrawDocs;

public interface DrawDocsRepository extends JpaRepository<DrawDocs, Integer> {

}
