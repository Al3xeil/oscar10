package com.fitness.login.service;

import com.fitness.login.model.CompetenceRating;
import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.user.User;

public interface UserService {
	void save(User user);

	User findByUsername(String name);

	CompetenceRating getCompetenceRatingFromUser(User user, int competenceId);

}