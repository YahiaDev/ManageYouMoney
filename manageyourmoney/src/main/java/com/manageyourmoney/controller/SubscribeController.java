package com.manageyourmoney.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;

import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.service.UserService;

@RestController
@RequestMapping("/api/subscribe")
public class SubscribeController {

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// return new BCryptPasswordEncoder();
	// }

	UserService userService;
	Logger logger = LogManager.getLogger(SubscribeController.class);

	SubscribeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.PUT)
	public void subscription(@RequestBody UserDocument user) {
		List<String> authoritiesList = Arrays.asList("ROLE_USER");
		user.setAuthorities(authoritiesList);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userService.addNewUser(user);
		logger.info("user add aded successfully");
	}

}
