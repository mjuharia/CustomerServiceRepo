package com.moso.microservice.customerservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moso.microservice.customerservice.enity.ServicingDrawDocument;

public interface ServicingDrawDocumentRepository extends JpaRepository<ServicingDrawDocument, Integer> {

}
