package com.fitness.login.service;

import java.util.List;

import com.fitness.login.model.CompetenceRating;
import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.competence.CompetenceCategory;
import com.fitness.login.model.competence.CompetenceStatus;
import com.fitness.login.model.competence.CompetenceType;
import com.fitness.login.model.user.User;

public interface CompetenceService {

	public List<Competence> getAllCompetence();
	
	public List<Competence> getAllCompetenceByType(Integer typeId);
	
	public List<CompetenceType> getAllTypes();
	
	public List<CompetenceCategory> getAllCategories();
	
	public List<CompetenceStatus> getAllStatus();
	public CompetenceStatus getStatusById(Integer statusId);
	
	public Competence getCompetenceById(Integer competenceId);
	
	public List<Competence> getCompetencesByName(String name);
	
	void save(Competence competence);

}