package it.jz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Observable;
import it.jz.repo.MessageRepo;


@Service
public class MessageServiceImpl implements MessageService
{

	@Autowired
	private MessageRepo messageRepo;
	
	
	@Override
	public Observable<String> getMessages()
	{
		return messageRepo.getMessages();
	}

}
