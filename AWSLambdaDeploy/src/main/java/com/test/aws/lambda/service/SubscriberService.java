package com.test.aws.lambda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.test.aws.lambda.model.Subscriber;

@Service
public class SubscriberService {
	
	private List<Subscriber> subscribers = new ArrayList<>();
	private AtomicInteger id = new AtomicInteger(0);
	
	public List<Subscriber> findAll() {
		return subscribers;
	}
	
	public void create(String email) {
		subscribers.add(new Subscriber(id.addAndGet(1), email));
	}

}