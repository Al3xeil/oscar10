package com.fitness.login.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fitness.login.model.user.User;
import com.fitness.login.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	public boolean validate(Object o) {
		User user = (User) o;

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
		// "NotEmpty");
		if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
			// errors.rejectValue("username", "Size.userForm.username");
			return false;
		}
		if (userService.findByUsername(user.getUsername()) != null) {
			// errors.rejectValue("username", "Duplicate.userForm.username");
			return false;
		}

		// ValidationUtils.rejectIfEmptyOrsWhitespace(errors, "password",
		// "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			// errors.rejectValue("password", "Size.userForm.password");
			return false;
		}

		if (!user.getPasswordconFirm().equals(user.getPassword())) {
			// errors.rejectValue("passwordconFirm",
			// "Diff.userForm.passwordconFirm");
			return false;
		}
		return true;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub

	}

}
