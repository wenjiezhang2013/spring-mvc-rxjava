package it.jz.service;

import java.util.List;

import rx.Observable;

public interface MessageService
{
	public Observable<List<String>> getMessages();
}
