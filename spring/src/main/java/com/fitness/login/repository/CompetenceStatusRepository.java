package com.fitness.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitness.login.model.competence.CompetenceStatus;

public interface CompetenceStatusRepository extends JpaRepository<CompetenceStatus, Integer> {
	

}
