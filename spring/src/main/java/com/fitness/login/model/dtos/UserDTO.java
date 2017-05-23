package com.fitness.login.model.dtos;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.login.model.user.User;

public class UserDTO extends ResourceSupport {
	
	private final User user;
	
	@JsonCreator
	public UserDTO(@JsonProperty("user") User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}

}
