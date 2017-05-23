package com.fitness.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.competence.CompetenceType;
import com.fitness.login.model.user.User;

public interface CompetenceRepository extends JpaRepository<Competence, Integer> {
	
	@Query("from Competence h where lower(h.name) like CONCAT('%', lower(:name), '%')")
	List<Competence> findByName(@Param("name") String name);
	
	List<Competence> findByType(CompetenceType type);

}
