package it.jz.repo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import io.reactivex.Observable;


@Repository
public class MessageRepoImpl implements MessageRepo
{

	@Override
	public Observable<String> getMessages()
	{
		// Assuming we are reading data from database from here, and getting a
		// hashset of string
		Set<String> messages = new HashSet<>();
		messages.add("test1");
		messages.add("test3");
		messages.add("test2");

		return Observable.fromIterable(messages);
	}

}
