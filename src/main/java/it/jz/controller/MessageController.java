package it.jz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.jz.service.MessageService;

@RestController
public class MessageController {
	@Autowired
	private MessageService messageService;

	@RequestMapping(path = "/test")
	public String test() {
		return "test";
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
