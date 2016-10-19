package it.jz.repo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import rx.Observable;
import rx.functions.Func1;

@Repository
public class MessageRepoImpl implements MessageRepo
{

	@Override
	public Observable<List<String>> getMessages()
	{
		// Assuming we are reading data from database from here, and getting a
		// hashset of string
		Set<String> messages = new HashSet<>();
		messages.add("test1");
		messages.add("test3");
		messages.add("test2");

		return Observable.from(messages)
		        .flatMap(new Func1<String, Observable<String>>()
		        {

			        public Observable<String> call(String t)
			        {
				        return Observable.just((t));
			        }
		        }).toList();
	}

}
