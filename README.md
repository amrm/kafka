# Apache Kafka
	
	1- Download Apache Kafka from https://kafka.apache.org/downloads
	2- Unzip it
	3- Configure Zookeeper property file -> kafka_directory/config/zookeeper.properties
	4- Configure Kafka property file -> kafka_directory/config/server.properties
	
	[Note] First start Zookeeper Server then apache Kafka Server
	
# Start Zookeeper Server
	
	bin/zookeeper-server-start.sh config/zookeeper.properties
	
# Start Apache Kafka Server

	bin/kafka-server-start.sh config/server.properties

# Default Port	(Kafka - Zookeeper)

	Kafka: PLAINTEXT://your.host.name:9092
	Zookeeper: 2181