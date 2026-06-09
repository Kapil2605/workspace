package com.ecommerce.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic orderConfirmedTopic() {
	    return TopicBuilder
	            .name(AppConstant.ORDER_CONFIRMED_TOPIC)
	            .partitions(3)
	            .replicas(1)
	            .build();
	}
	
	@Bean
	public NewTopic orderUpdatedTopic() {
	    return TopicBuilder
	            .name(AppConstant.ORDER_UPDATED_TOPIC)
	            .partitions(3)
	            .replicas(1)
	            .build();
	}
}