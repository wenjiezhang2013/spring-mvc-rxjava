package it.jz.repo;

import java.util.List;

import rx.Observable;

public interface MessageRepo
{
	public Observable<List<String>> getMessages();
}
