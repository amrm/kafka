package com.daily.technical.knowledge.Kafka.config;

import java.text.SimpleDateFormat;

/**
 * 
 * @author Amr Abdeldayem
 *
 */

public class AppConstants {
	
	public static final String TopicName = "daily-knowledge-events";
	public static final String ConsumerGroup ="daily-knowledge-group";	
	public static final String bootstrapServers = "localhost:9092";
	
	public static final SimpleDateFormat SimpleFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	
}
