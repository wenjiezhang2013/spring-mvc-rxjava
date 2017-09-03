package it.jz.repo;

import io.reactivex.Observable;


public interface MessageRepo
{
	public Observable<String> getMessages();
}
