package com.daily.technical.knowledge.Kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.daily.technical.knowledge.Kafka.config.AppConstants;

/**
 * 
 * @author Amr Abdeldayem
 *
 */

@Service
public class DailyKnowledgeProducer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String msg) {
		
		kafkaTemplate.send(AppConstants.TopicName,msg);
	
	}
	
}
