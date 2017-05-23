package com.fitness.login.rest;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.user.User;
import com.fitness.login.service.UserService;
import com.fitness.login.validator.UserValidator;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserRestController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<User> registration(@RequestBody User userForm) {
		if (!userValidator.validate(userForm)) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}

		userService.save(userForm);

		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User username) {
		User userTryingToLog = userService.findByUsername(username.getUsername());
		// if(!userTryingToLog.getPasswordconFirm().equals(userForm.getPassword())){
		// //BAd PAss
		// return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		// }

		return userTryingToLog;
	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		if (user.getId() == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		//password don't change
		String userpassword = userService.findByUsername(user.getUsername()).getPasswordconFirm();
		user.setPassword(userpassword);
		userService.save(user);

		return new ResponseEntity<User>(HttpStatus.OK);
	}

}