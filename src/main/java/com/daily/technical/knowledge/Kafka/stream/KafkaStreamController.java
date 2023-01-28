package com.daily.technical.knowledge.Kafka.stream;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/kafka/stream")
public class KafkaStreamController {
	
	@Autowired
	WordsCountJob frequentWordsProcessing;
	
	@GetMapping("/words-count/job")
	public ResponseEntity runWordsCountJob(){
		frequentWordsProcessing.startJob();	
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
