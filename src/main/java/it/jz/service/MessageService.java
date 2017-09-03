package it.jz.service;

import io.reactivex.Observable;


public interface MessageService
{
	public Observable<String> getMessages();
}
