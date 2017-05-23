package com.fitness.login.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.CompetenceRating;
import com.fitness.login.model.user.Role;
import com.fitness.login.model.user.User;
import com.fitness.login.repository.RoleRepository;
import com.fitness.login.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void save(User user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		Set<Role> roles = new HashSet<>(roleRepository.findAll());
		for (Role role : roles) {
			if (Role.ROLE_STANDART.equals(role.getId())) {
				user.addRole(role);
			}
		}
		// user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public CompetenceRating getCompetenceRatingFromUser(User user, int competenceeId) {
		if (user.getCompetenceRating() != null) {
			for (CompetenceRating userCompetenceRating : user.getCompetenceRating()) {
				if (competenceeId == userCompetenceRating.getCompetence().getId()) {
					return userCompetenceRating;
				}
			}
		}
		return null;
	}

}
