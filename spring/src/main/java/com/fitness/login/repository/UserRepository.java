package com.fitness.login.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.login.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String name);

}
