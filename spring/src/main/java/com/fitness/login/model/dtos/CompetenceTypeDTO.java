package com.fitness.login.model.dtos;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.login.model.competence.CompetenceType;
import com.fitness.login.model.user.User;
import com.fitness.login.rest.CompetenceRestController;

public class CompetenceTypeDTO extends ResourceSupport {

	private final CompetenceType competenceType;

	@JsonCreator
	public CompetenceTypeDTO(@JsonProperty("competenceType") CompetenceType competenceType) {
		this.competenceType = competenceType;
		add(linkTo(methodOn(CompetenceRestController.class).getCompentenceByType(competenceType.getId()))
				.withSelfRel());
	}

	public CompetenceType getCompetenceType() {
		return competenceType;
	}

}
