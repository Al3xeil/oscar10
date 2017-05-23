package com.fitness.login.model.dtos;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.login.model.user.Role;
import com.fitness.login.model.user.User;

public class RoleDTO extends ResourceSupport {
	
	private final Role role;
	
	@JsonCreator
	public RoleDTO(@JsonProperty("role") Role role){
		this.role = role;
	}
	
	public Role getRole(){
		return role;
	}

}
