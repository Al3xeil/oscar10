package com.fitness.login.model.dtos;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.login.model.competence.CompetenceUnit;
import com.fitness.login.model.user.User;

public class CompetenceUnitDTO extends ResourceSupport {

	private final CompetenceUnit competenceUnit;

	@JsonCreator
	public CompetenceUnitDTO(@JsonProperty("competenceUnit") CompetenceUnit competenceUnit) {
		this.competenceUnit = competenceUnit;
	}

	public CompetenceUnit getCompetenceUnit() {
		return competenceUnit;
	}

}
