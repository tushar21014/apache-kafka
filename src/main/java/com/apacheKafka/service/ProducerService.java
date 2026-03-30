package com.apacheKafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	private static final String TOPIC = "mouse";
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public ProducerService(KafkaTemplate<String, String> kafkaTemplate)
    {
    	this.kafkaTemplate = kafkaTemplate;
    }
    
    public void sendMessage(String message) {
    	kafkaTemplate.send(TOPIC, message);
        System.out.println("Message sent: " + message);

    }
    
}
