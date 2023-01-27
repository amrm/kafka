package com.daily.technical.knowledge.Kafka.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.daily.technical.knowledge.Kafka.config.AppConstants;

/**
 * 
 * @author Amr Abdeldayem
 *
 */

@Service
public class DailyKnowledgeConsumer {

	public static List<KafkaMessage> messagesCache =new ArrayList<>();
	
	//using multiple consumers on the same consumer group (node 1, node 2)
	
	@KafkaListener(topics = AppConstants.TopicName, groupId = AppConstants.ConsumerGroup)
	/*@KafkaListener(groupId = AppConstants.ConsumerGroup, topicPartitions = {
		    @TopicPartition(
		            topic = AppConstants.TopicName,
		            partitions = { "0", "2" }
		        )})*/
	public void consume1(String message) {
		
		System.out.println("Message: "+message);
		
		messagesCache.add(new KafkaMessage(message,AppConstants.ConsumerGroup,1));
	}
	
	/*@KafkaListener(groupId = AppConstants.ConsumerGroup, topicPartitions = {
		    @TopicPartition(
		            topic = AppConstants.TopicName,
		            partitions = { "2", "4" }
		        )})*/
	@KafkaListener(topics = AppConstants.TopicName, groupId = AppConstants.ConsumerGroup)
	public void consume2(String message) {
		
		System.out.println("Message: "+message);
		
		messagesCache.add(new KafkaMessage(message,AppConstants.ConsumerGroup,2));
	}
}
