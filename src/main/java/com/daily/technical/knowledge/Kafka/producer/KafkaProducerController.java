package com.daily.technical.knowledge.Kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Amr Abdeldayem
 *
 */

@RestController
@RequestMapping("/api/kafka/producer")
public class KafkaProducerController {

	@Autowired
	DailyKnowledgeProducer dailyKnowledgeProducer;
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<String>  publishMessage(@PathVariable("message") String message) {
		dailyKnowledgeProducer.sendMessage(message);
		return new ResponseEntity<String>("message sent successfully to Kafka",HttpStatus.OK);
	}
}
