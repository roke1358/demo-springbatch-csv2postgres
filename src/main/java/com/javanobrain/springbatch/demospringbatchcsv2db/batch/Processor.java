package com.javanobrain.springbatch.demospringbatchcsv2db.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.javanobrain.springbatch.demospringbatchcsv2db.domain.State;
import com.javanobrain.springbatch.demospringbatchcsv2db.domain.User;

@Component
public class Processor implements ItemProcessor<User, User>{
	
	@Override
	public User process(User user) throws Exception {
		
		State state = State.valueOfName(user.getState());
		user.setState(state.getAbbreviation());
		return user;
	}
}
