package com.apacheKafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apacheKafka.websocket.SessionManager;

@Service
public class ConsumerService {

	private final SessionManager sessionManager; 
	
	public ConsumerService(SessionManager sessionManager) 
	{ 
		this.sessionManager = sessionManager;
	}
	
	@KafkaListener(topics = "mouse", groupId = 	"group_id")
    public void consume(String message) {
        System.out.println("Message received: " + message);
        sessionManager.broadcast(message);
    }
}
