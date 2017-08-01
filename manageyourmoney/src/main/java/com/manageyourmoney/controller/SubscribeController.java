package com.manageyourmoney.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.service.UserService;

@RestController
@RequestMapping("/api/subscribe")
public class SubscribeController {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private static final Logger LOG = (Logger) LogManager.getLogger(SubscribeController.class.getName());

	UserService userService;
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(SubscribeController.class);

	SubscribeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.PUT)
	public void subscription(@RequestBody UserDocument user) {
		//logger.error("error to get user");
		List<String> authoritiesList = Arrays.asList("ROLE_USER");
		user.setAuthorities(authoritiesList);
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		userService.addNewUser(user);
		logger.info("add user aded successfully");

	}

}
