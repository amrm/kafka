package com.daily.technical.knowledge.Kafka.consumer;

import java.io.Serializable;
import java.util.Date;

import com.daily.technical.knowledge.Kafka.config.AppConstants;

/**
 * 
 * @author Amr Abdeldayem
 *
 */

public class KafkaMessage implements Serializable{

	private static final long serialVersionUID = 1L;

	private String message;
	private String date;
	private String consumerGroup;
	private Integer node;
	
	public KafkaMessage(String message,String conumerGroup, Integer node) {
		this.message =message;
		this.date=AppConstants.SimpleFormat.format(new Date());
		this.consumerGroup=conumerGroup;
		this.node=node;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getConsumerGroup() {
		return consumerGroup;
	}

	public void setConsumerGroup(String consumerGroup) {
		this.consumerGroup = consumerGroup;
	}

	public Integer getNode() {
		return node;
	}

	public void setNode(Integer node) {
		this.node = node;
	}

	
}
