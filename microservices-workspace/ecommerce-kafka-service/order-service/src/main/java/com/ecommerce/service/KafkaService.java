package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderRequest;

@Service
public class KafkaService {

	@Autowired
	KafkaTemplate<String, OrderRequest> kafkaTemplate;

    public void sendMessage(String topic, String key, OrderRequest orderRequest) {
        kafkaTemplate.send(topic, key, orderRequest);
    }
}
