package com.example.kubernetes.service;

import com.example.kubernetes.entity.Employee;

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
	
	
	@Override
	public void sendMessage(Employee e) throws JMSException {
		log.info("Sending message: [{}]", e);
		this.jmsTemplate.convertAndSend("springboot.kubernetes", e);
	}

}
