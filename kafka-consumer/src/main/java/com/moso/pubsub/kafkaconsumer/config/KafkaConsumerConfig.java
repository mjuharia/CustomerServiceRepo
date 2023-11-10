package com.moso.pubsub.kafkaconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


//@EnableKafka
//@Configuration
public class KafkaConsumerConfig {
	
	private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
	
	//@Bean
	public ConsumerFactory<String, String> consumerFactory(){ 
		// Creating a Map of string-object pairs 
	    Map<String, Object> config = new HashMap<>(); 
	  
	    logger.info("Entering KafkaConsumerConfig::ConsumerFactory...");
	    // Adding the Configuration 
	    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "cheerful-tomcat-14938-us1-kafka.upstash.io:9092"); 
	    config.put(ConsumerConfig.GROUP_ID_CONFIG, "moso-group-1"); 
	    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); 
	    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    config.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-256");
	    config.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
	    config.put(SaslConfigs.SASL_JAAS_CONFIG, 
	    		"org.apache.kafka.common.security.scram.ScramLoginModule required username=\"Y2hlZXJmdWwtdG9tY2F0LTE0OTM4JA_VTMJ9r4MY3F9PTZYhFLRNJLBLMhFmX8E\" password=\"MGY2NTEyM2MtNjVlNC00Zjk0LTkwZjMtYTlmYmQ5OGE4YjQx\";");
	    
	    return new DefaultKafkaConsumerFactory<>(config); 
	} 
	  
	// Creating a Listener 
	//@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory() { 
		logger.info("Entering KafkaConsumerConfig::ConcurrentKafkaListenerContainerFactory...");
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>(); 
	    factory.setConsumerFactory(consumerFactory()); 
	    return factory; 
	}
	
	
	
}
