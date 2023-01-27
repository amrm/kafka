# Apache Kafka
	(Apache Kafka is an open-source distributed event streaming platform )
	
	1- Download Apache Kafka from https://kafka.apache.org/downloads
	2- Unzip it
	3- Configure Zookeeper property file -> kafka_directory/config/zookeeper.properties
	4- Configure Kafka property file -> kafka_directory/config/server.properties
	
	[Note] First start Zookeeper Server then apache Kafka Server
	
# Start Zookeeper Server
	
	Command: 
		bin/zookeeper-server-start.sh config/zookeeper.properties
	
# Start Apache Kafka Server

	Command: 
		bin/kafka-server-start.sh config/server.properties

# Default Port	(Kafka - Zookeeper)

	Kafka: PLAINTEXT://your.host.name:9092
	Zookeeper: 2181

# Kafka Quickstart
	Link: 
		https://kafka.apache.org/quickstart
	
# Create new topic

	Command: 
		bin/kafka-topics.sh --create --topic daily-knowledge-events --bootstrap-server localhost:9092
	
	Result: 
		Created topic daily-knowledge-events.

# Show Kafka Topic

	Command:
		bin/kafka-topics.sh --list --bootstrap-server localhost:9092
	
	Results:
		
		daily-knowledge-events

# Describe Topic

	Command:
		bin/kafka-topics.sh --describe --topic daily-knowledge-events --bootstrap-server localhost:9092

	Result:
		Topic: daily-knowledge-events	TopicId: sy7u8s7GQ1mj7yrV37H-rA	PartitionCount: 1	ReplicationFactor: 1	Configs: 
		Topic: daily-knowledge-events	Partition: 0	Leader: 0	Replicas: 0	Isr: 0


# Write events to topic

	Command:
		bin/kafka-console-producer.sh --topic daily-knowledge-events --bootstrap-server localhost:9092
		
		> This is first event
		> This is second event
		> This is last one

	

# Read all events from topic

	Command:
		bin/kafka-console-consumer.sh --topic daily-knowledge-events --from-beginning --bootstrap-server localhost:9092

	Result:
		This is first event
		This is second event
		This is last one

# Read some events from topic/partition

	Command: 
		bin/kafka-console-consumer.sh --topic daily-knowledge-events --partition 0 --offset 2 --bootstrap-server localhost:9092
	Result:
		This is last one

# adding new partitions per topic
	
	command: 
		bin/kafka-topics.sh --alter --bootstrap-server localhost:9092 --topic daily-knowledge-events --partitions 4



# Next
	
	1- Kafka Stream
		Link: https://kafka.apache.org/documentation/streams/
	2- Save in partitions based on key (the same message that has the same hashkey would be saved in on partition all the time)