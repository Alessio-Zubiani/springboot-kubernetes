package com.example.kubernetes.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

	@Bean
	public Queue createUserRegistrationQueue() {
        return new Queue("springboot-kubernetes");
    }
	
}
