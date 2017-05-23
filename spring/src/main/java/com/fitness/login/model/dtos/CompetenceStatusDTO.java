package com.fitness.login.model.dtos;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.login.model.competence.CompetenceStatus;
import com.fitness.login.model.user.User;

public class CompetenceStatusDTO extends ResourceSupport {

	private final CompetenceStatus competenceStatus;

	@JsonCreator
	public CompetenceStatusDTO(@JsonProperty("competenceStatus") CompetenceStatus competenceStatus) {
		this.competenceStatus = competenceStatus;
	}

	public CompetenceStatus getCompetenceStatus() {
		return competenceStatus;
	}

}
