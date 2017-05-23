package com.fitness.login.model.dtos;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.login.model.competence.CompetenceCategory;
import com.fitness.login.model.user.User;

//ResourceSupport -> Hateoas Feature um ein Link in dem Json zu hinzufügen
public class CompetenceCategoryDTO extends ResourceSupport {

	private final CompetenceCategory competenceCategory;

	@JsonCreator
	public CompetenceCategoryDTO(@JsonProperty("competenceCategory") CompetenceCategory competenceCategory) {
		this.competenceCategory = competenceCategory;
	}

	public CompetenceCategory getCompetenceCategory() {
		return competenceCategory;
	}

}
