package com.fitness.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.competence.CompetenceType;
import com.fitness.login.model.user.User;

public interface CompetenceTypeRepository extends JpaRepository<CompetenceType, Integer> {
	
	List<CompetenceType> findByName(String name);

}
