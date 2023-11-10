package com.moso.pubsub.kafkaconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.moso.pubsub.kafkaconsumer.entity.Customer;

import jakarta.validation.Valid;



/*@FeignClient(name="currency-exchange", url="localhost:8000")
 * Removing url parameter allows Feign to load balance among all registered
 * currency-exchange instances within the naming-server.
 * 
 */
//@FeignClient(name="currency-exchange")
// Adding below for Kubernetes
//@FeignClient(name="currency-exchange", url="${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
@FeignClient(name="customer-service", url="${CUSTOMER_SERVICE_URI:http://localhost}:7100")
public interface CustomerServiceProxy {
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> sendCustomer(@Valid @RequestBody Customer cust);
}
