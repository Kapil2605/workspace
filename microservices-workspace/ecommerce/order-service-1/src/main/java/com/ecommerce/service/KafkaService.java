package com.ecommerce.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderRequest;
import com.ecommerce.entity.OrderEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaService {

	@Autowired
	KafkaTemplate<String, OrderRequest> kafkaTemplate;

    public void sendMessage(String topic, String key, OrderRequest orderRequest) {
        kafkaTemplate.send(topic, key, orderRequest);
    }
	

}