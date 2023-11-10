package com.moso.microservice.customerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class CustomerContactNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 999;
	
	public CustomerContactNotFoundException (String message) {
		super(message);
	}
}
