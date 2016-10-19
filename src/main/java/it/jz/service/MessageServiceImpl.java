package it.jz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jz.repo.MessageRepo;
import rx.Observable;


@Service
public class MessageServiceImpl implements MessageService
{

	@Autowired
	private MessageRepo messageRepo;
	
	
	@Override
	public Observable<List<String>> getMessages()
	{
		return messageRepo.getMessages();
	}

}
