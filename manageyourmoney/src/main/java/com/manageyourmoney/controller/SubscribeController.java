package com.manageyourmoney.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.common.MymMessage;
import com.manageyourmoney.exeption.UserExitsException;
import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.restcustomerror.ApiError;
import com.manageyourmoney.service.impl.UserServiceImpl;

/**
 * @author Yahia
 *
 */
@RestController
@RequestMapping("/api/subscribe")
public class SubscribeController {

	UserServiceImpl userService;
	Logger logger = LogManager.getLogger(SubscribeController.class);

	SubscribeController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.PUT)
	public ResponseEntity<Object> subscription(@RequestBody final UserDocument user) {
		// List<String> authoritiesList = Arrays.asList("ROLE_USER");
		// user.setAuthorities(authoritiesList);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		try {
			userService.addNewUser(user);
			logger.info(MymMessage.CREATE_USER_MSG_SUCCESS);
			return new ResponseEntity<Object>(user, HttpStatus.ACCEPTED);
		} catch (UserExitsException e) {
			List<String> errors = Arrays.asList(MymMessage.CREATE_USER_ERROR);
			ApiError apiError = new ApiError(HttpStatus.CONFLICT, MymMessage.CREATE_USER_MSG_ERROR, errors);
			logger.error(MymMessage.CREATE_USER_MSG_ERROR);
			return new ResponseEntity<Object>(apiError, apiError.getStatus());
		}

	}

}
