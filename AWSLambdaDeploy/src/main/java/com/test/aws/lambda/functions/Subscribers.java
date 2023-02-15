package com.test.aws.lambda.functions;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.aws.lambda.model.Subscriber;
import com.test.aws.lambda.service.SubscriberService;

@Configuration
public class Subscribers {

	private static final Logger log = LoggerFactory.getLogger(Subscribers.class);
	private final SubscriberService subscribers;

	public Subscribers(SubscriberService subscribers) {
		this.subscribers = subscribers;
	}
	
	@Bean
	public Supplier<List<Subscriber>> findAll(){
		log.info("Subscriber.findAll was called.");
		return () -> subscribers.findAll();
	}
	
	@Bean
	public Consumer<String> create(){
		return (email) -> subscribers.create(email);
	}
}