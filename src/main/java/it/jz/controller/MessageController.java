package it.jz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.jz.service.MessageService;

@RestController
public class MessageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private StringRedisTemplate stringRedis;

	@RequestMapping(path = "/hello")
	public String test1() {
		
		LOGGER.info("Sending message...");
		stringRedis.convertAndSend("chat", "Hello from Redis!");

		return "Sent hello to redis";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/messages")
	public List<String> messages() {
		List<String> result = new ArrayList<>();
		messageService.getMessages().blockingIterable().forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				result.add(t);
			}
		});

		return result;

	}
}
