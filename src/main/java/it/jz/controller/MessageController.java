package it.jz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.jz.service.MessageService;

@RestController
public class MessageController
{
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(path = "/test")
	public String test()
	{
		return "test";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/messages")
	public List<String> messages()
	{
		return messageService.getMessages().toBlocking().single();

	}
}
