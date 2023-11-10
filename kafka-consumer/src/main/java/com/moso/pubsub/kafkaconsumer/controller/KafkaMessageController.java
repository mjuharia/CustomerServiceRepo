package com.moso.pubsub.kafkaconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moso.pubsub.kafkaconsumer.CustomerServiceProxy;
import com.moso.pubsub.kafkaconsumer.entity.Customer;

@RestController
public class KafkaMessageController {

	private Logger logger = LoggerFactory.getLogger(KafkaMessageController.class);
	
	@Autowired
	CustomerServiceProxy cusProxy;
	
	@KafkaListener(topics = "moso-topic", groupId = "moso-group-1")   
	public void listen(@Payload String message, 
			  @Header(KafkaHeaders.RECEIVED_PARTITION) String partition, 
			  @Header(KafkaHeaders.OFFSET) String offset,
			  @Header(KafkaHeaders.RECEIVED_KEY) String key,
			  @Header(KafkaHeaders.GROUP_ID) String groupID) { 
		// Log Message 
		
		logger.info("KafkaMessageController::listen --> \n\n" +
				"---------------------------------\n" +
				"Message = " + message + "\n" +
				"GroupID = " + groupID + "\n" +
				"Parttion = " + partition + "\n" +
				"Key = " + key + "\n" +
				"Offset = " + offset + "\n" +
				"---------------------------------\n");
		try {
			logger.info("KafkaMessageController::listen - sending Customer via customer-service proxy...");
			Customer cust = new ObjectMapper().readValue(message, Customer.class);
			ResponseEntity<Customer> retCust = cusProxy.sendCustomer(cust);
			logger.info("KafkaMessageController::listen response received - " + retCust);
		}
		catch(Exception e) {
			logger.error("KafkaMessageController::listen - sending Customer via customer-service proxy failed ... ", e);
		}
		
	} 
	
	/* The NewTopic bean causes the topic to be created on the broker; it is not needed if the topic already exists.
	 @Bean
	 public NewTopic topic() {
	        return TopicBuilder.name("topic1")
	                .partitions(10)
	                .replicas(1)
	                .build();
	    }
	*/
}
