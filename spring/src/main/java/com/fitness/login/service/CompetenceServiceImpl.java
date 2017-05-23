package com.fitness.login.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.competence.CompetenceCategory;
import com.fitness.login.model.competence.CompetenceStatus;
import com.fitness.login.model.competence.CompetenceType;
import com.fitness.login.model.user.User;
import com.fitness.login.repository.CompetenceCategoryRepository;
import com.fitness.login.repository.CompetenceRepository;
import com.fitness.login.repository.CompetenceStatusRepository;
import com.fitness.login.repository.CompetenceTypeRepository;
import com.fitness.login.repository.UserRepository;

@Service
public class CompetenceServiceImpl implements CompetenceService {

	@Autowired
	private CompetenceRepository competenceRepository;

	@Autowired
	private CompetenceTypeRepository typeRepository;

	@Autowired
	private CompetenceStatusRepository competenceStatusRepository;
	
	@Autowired
	private CompetenceCategoryRepository competenceCategoryRepository;

	@Override
	public List<Competence> getAllCompetence() {
		return competenceRepository.findAll();
	}
	
	@Override
	public List<Competence> getAllCompetenceByType(Integer typeId) {
		CompetenceType type = typeRepository.findOne(typeId);
		List<Competence> comptenceList = competenceRepository.findByType(type);
		return comptenceList;
	}

	@Override
	public Competence getCompetenceById(Integer competenceId) {
		return competenceRepository.findOne(competenceId);
	}

	@Override
	public List<Competence> getCompetencesByName(String name) {
		return competenceRepository.findByName(name);
	}

	@Override
	public List<CompetenceType> getAllTypes() {
		return typeRepository.findAll();
	}

	@Override
	public void save(Competence competence) {
		competenceRepository.save(competence);
	}

	@Override
	public List<CompetenceStatus> getAllStatus() {
		return competenceStatusRepository.findAll();
	}

	@Override
	public CompetenceStatus getStatusById(Integer statusId) {
		return competenceStatusRepository.findOne(statusId);
	}

	@Override
	public List<CompetenceCategory> getAllCategories() {
		return competenceCategoryRepository.findAll();
	}

}
