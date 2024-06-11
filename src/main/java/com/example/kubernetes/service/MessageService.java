package com.example.kubernetes.service;

import com.example.kubernetes.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.jms.JMSException;

public interface MessageService {
	
	void sendMessage(Employee e) throws JMSException, JsonProcessingException;

}
