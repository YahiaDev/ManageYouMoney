package com.manageyourmoney.controller;

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
		logger.info("add new user");
		logger.error("error to get user");
		/*
		 * MessageDigest md = MessageDigest.getInstance("SHA-512"); byte[] bytes
		 * = md.digest(user.getPassword().getBytes("UTF-8")); StringBuilder sb =
		 * new StringBuilder(); for (int i = 0; i < bytes.length; i++) {
		 * sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,
		 * 16).substring(1)); }
		 */
		
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		userService.addNewUser(user);

	}

}
