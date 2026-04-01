package com.apacheKafka.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.apacheKafka.service.ProducerService;

@RestController
public class KafkaController {

    private final ProducerService producerService;

    // Constructor injection (recommended)
    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health(){
    	return ResponseEntity.ok("Working");
    }
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        try {
            producerService.sendMessage(message);
            return ResponseEntity.ok("Message sent successfully: " + message);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error sending message: " + e.getMessage());
        }
    }
}