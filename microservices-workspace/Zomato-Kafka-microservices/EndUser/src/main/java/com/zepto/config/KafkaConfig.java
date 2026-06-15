package com.zepto.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

	@KafkaListener(topics=AppConstant.LOCATION_UPDATE_TOPIC,groupId=AppConstant.GROUP_ID)
	public void updateLocation(ConsumerRecord<String, String> record) {
		System.out.println(
			    " Partition: " + record.partition() +
			    " | Offset: " + record.offset() +
			    " | Message: " + record.value()
			);
	}
	
}
