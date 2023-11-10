package com.moso.pubsub.kafkaconsumer.controller;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


//@RestController
public class SimpleController {
	private Logger logger = LoggerFactory.getLogger(SimpleController.class);
	
	
	public void consumer() {
		String topic = "moso-topic";
		//String messageKey = "moso-key-1";
		String groupid = "moso-group-1";
	
		// Create Producer Properties
		Properties properties = new Properties();
		//properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
		properties.setProperty("bootstrap.servers", "cheerful-tomcat-14938-us1-kafka.upstash.io:9092");
		properties.setProperty("sasl.mechanism", "SCRAM-SHA-256");
		properties.setProperty("security.protocol", "SASL_SSL");
		properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"Y2hlZXJmdWwtdG9tY2F0LTE0OTM4JA_VTMJ9r4MY3F9PTZYhFLRNJLBLMhFmX8E\" password=\"MGY2NTEyM2MtNjVlNC00Zjk0LTkwZjMtYTlmYmQ5OGE4YjQx\";");
		properties.setProperty("key.serializer", StringDeserializer.class.getName());
		properties.setProperty("value.serializer", StringDeserializer.class.getName());
		properties.setProperty("group.id", groupid);
		
		// Options are none/earliest/latest
		properties.setProperty("auto.offset.reset", "earliest");
		
		// Create the Consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
		
		// Subscribe to the topic
		consumer.subscribe(Arrays.asList(topic));
		
		// Poll data
		while(true) {
			ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));
			
			for (ConsumerRecord<String, String> record: records) {
				logger.info("Key - " + record.key() + " ::: " + "Value - " + record.value());
				logger.info("Partition - " + record.partition() + " ::: " + "Offset - " + record.offset());
			}
			
		}
		
	}
}
