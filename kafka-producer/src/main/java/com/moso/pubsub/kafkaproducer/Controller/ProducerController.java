package com.moso.pubsub.kafkaproducer.Controller;
import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moso.pubsub.kafkaproducer.entity.Customer;

import org.apache.kafka.common.serialization.StringSerializer;

@RestController
public class ProducerController {

	private Logger logger = LoggerFactory.getLogger(ProducerController.class);

	
	@Autowired
	Customer lCust;
	
		
	/**** BEGIN CUSTOMER MESSAGE PRODUCER TO KAFKA ****/
		
	@PostMapping("/customer")
	public void publishCustomer(@RequestBody Customer cust){
		
		logger.info("Entering ProducerController::publishCustomer with {}", cust.toString());
		
		String topic = "moso-topic";
		String messageKey = "moso-key-1";
		
		// Create Producer Properties
		Properties properties = new Properties();
		//properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
		properties.setProperty("bootstrap.servers", "cheerful-tomcat-14938-us1-kafka.upstash.io:9092");
		properties.setProperty("sasl.mechanism", "SCRAM-SHA-256");
		properties.setProperty("security.protocol", "SASL_SSL");
		properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"Y2hlZXJmdWwtdG9tY2F0LTE0OTM4JA_VTMJ9r4MY3F9PTZYhFLRNJLBLMhFmX8E\" password=\"MGY2NTEyM2MtNjVlNC00Zjk0LTkwZjMtYTlmYmQ5OGE4YjQx\";");
		
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		
		// Create the Producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
		try {
			ObjectMapper Obj = new ObjectMapper();
			String jsonCust = Obj.writeValueAsString(cust);
			logger.info("ProducerController::publishCustomer converted Customer to JSON {}", jsonCust);
			//ProducerRecord<String, String> producerRecord = new ProducerRecord<>("moso-topic", jsonCust);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, messageKey, jsonCust);
			
			// Send data
			producer.send(producerRecord);
			
			// Flush and close the producer
			// Flush implies to instruct the producer to send all the data and
			// block until done -- synchronous operation
			producer.flush();
			
			//Close the producer
			producer.close();
		}
		catch (IOException e) {
			logger.error("ERROR in ProducerController::publishCustomer ", e);
			
		}
		
	}
	
	@PostMapping("/customer-with-callback")
	public void publishCustomerWithCallBack(@RequestBody Customer cust){
		
		logger.info("Entering ProducerController::publishCustomer with {}", cust.toString());
		
		String topic = "moso-topic";
		String messageKey = "moso-key-1";
		
		// Create Producer Properties
		Properties properties = new Properties();
		//properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
		properties.setProperty("bootstrap.servers", "cheerful-tomcat-14938-us1-kafka.upstash.io:9092");
		properties.setProperty("sasl.mechanism", "SCRAM-SHA-256");
		properties.setProperty("security.protocol", "SASL_SSL");
		properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"Y2hlZXJmdWwtdG9tY2F0LTE0OTM4JA_VTMJ9r4MY3F9PTZYhFLRNJLBLMhFmX8E\" password=\"MGY2NTEyM2MtNjVlNC00Zjk0LTkwZjMtYTlmYmQ5OGE4YjQx\";");
		
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		
		// Don't use in production this is used to demonstrate Sticky partitioner performance improvement 
		//properties.setProperty("batch.size", "400");
		
		// Create the Producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
		try {
			ObjectMapper Obj = new ObjectMapper();
			String jsonCust = Obj.writeValueAsString(cust);
			logger.info("ProducerController::publishCustomer converted Customer to JSON {}", jsonCust);
			//ProducerRecord<String, String> producerRecord = new ProducerRecord<>("moso-topic", jsonCust);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, messageKey, jsonCust);
			
			// Send data
			producer.send(producerRecord, new Callback() {
				public void onCompletion(RecordMetadata metadata, Exception e) {
					if (e == null) {
						// record was successful
						logger.info("ProducerController::publishCustomer received RecordMetadata :\n" +
									"Topic: " + metadata.topic() + "\n" +
									"Key: " + messageKey + "\n" +
									"Partition: " + metadata.partition() + "\n" +
									"Offset: " + metadata.offset() + "\n" +
									"Timestamp: " + metadata.timestamp() + "\n" );
					}
					else {
						logger.error("ProducerController::publishCustomer ERROR while producing message ", e);
					}
				}
				
			});
			
			// Flush and close the producer
			// Flush implies to instruct the producer to send all the data and
			// block until done -- synchronous operation
			producer.flush();
			
			//Close the producer
			producer.close();
		}
		catch (IOException e) {
			logger.error("ERROR in ProducerController::publishCustomer ", e);
			
		}
		
	}
	
	@GetMapping("/customer")
	public Customer consumeCustomer(){
		
		
		return lCust;
	}
	
}
