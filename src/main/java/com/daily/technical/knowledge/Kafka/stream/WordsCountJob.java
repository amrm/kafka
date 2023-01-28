package com.daily.technical.knowledge.Kafka.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.stereotype.Service;

import com.daily.technical.knowledge.Kafka.config.AppConstants;
/**
 * 
 * @author Amr Abdeldayem
 *
 */

@Service
public class WordsCountJob {

	private Path stateDirectory;
	
	public Properties getStreamConfiguration() {
		
		Properties streamsConfiguration = new Properties();
		streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-app");
		streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.bootstrapServers);
		streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		
		try {
			this.stateDirectory = Files.createTempDirectory("kafka-streams");
			streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG, this.stateDirectory.toAbsolutePath().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return streamsConfiguration;
				
	}
	
	public StreamsBuilder getStreamBuilder() {
		//Streaming Topology
		StreamsBuilder builder = new StreamsBuilder();
		KStream<String, String> textLines = builder.stream(AppConstants.TopicName);
		Pattern pattern = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);

		KTable<String, Long> wordCounts = textLines.flatMapValues(value -> Arrays.asList(pattern.split(value.toLowerCase())))
		  .groupBy((key, word) -> word).count();
		
		wordCounts.toStream()
		  .foreach((word, count) -> System.out.println("word: " + word + " -> " + count));
		
		String outputTopic = "outputTopic";
		wordCounts.toStream().to(outputTopic, Produced.with(Serdes.String(), Serdes.Long()));
		return builder;
	}
	
	public void startJob() {
		Topology topology = getStreamBuilder().build();
		KafkaStreams streams = new KafkaStreams(topology, getStreamConfiguration());
		streams.start();
	
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			streams.close();
		}
	}
}
