package com.apacheKafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@KafkaListener(topics = "mouse", groupId = 	"group_id")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }
}
