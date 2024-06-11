package com.example.kubernetes.service;

import com.example.kubernetes.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import jakarta.jms.JMSException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

	private final JmsTemplate jmsTemplate;
	private final ObjectMapper mapper;
	
	
	@Override
	public void sendMessage(Employee e) throws JMSException, JsonProcessingException {
		String message = this.mapper.writeValueAsString(e);
		log.info("Sending message: [{}]", e);
		
		this.jmsTemplate.convertAndSend("springboot.kubernetes", message);
	}

}
