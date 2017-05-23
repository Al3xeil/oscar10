package com.fitness.login.model.dtos;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.user.User;
import com.fitness.login.rest.CompetenceRestController;

public class CompetenceDTO extends ResourceSupport {
	
	private final Competence competence;
	
	@JsonCreator
	public CompetenceDTO(@JsonProperty("competence") Competence competence){
		this.competence = competence;
		add(linkTo(methodOn(CompetenceRestController.class).getCompentenceDetail(competence.getId()))
				.withSelfRel());
	}
	
	public Competence getCompetence(){
		return competence;
	}

}
