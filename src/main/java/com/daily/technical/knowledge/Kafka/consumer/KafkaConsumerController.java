package com.daily.technical.knowledge.Kafka.consumer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Amr Abdeldayem
 *
 */

@RestController
@RequestMapping("/api/kafka/consumer")
public class KafkaConsumerController {
	
	@GetMapping("/read/all")
	public ResponseEntity<List<KafkaMessage>>  read(){
			
		return new ResponseEntity<>(DailyKnowledgeConsumer.messagesCache,HttpStatus.OK);
	}
}
