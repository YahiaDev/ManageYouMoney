package com.manageyourmoney.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.service.UserService;

@RestController
@RequestMapping("/api/subscribe")
public class SubscribeController {

	UserService userService;

	SubscribeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.PUT)
	public void subscription(@RequestBody UserDocument user) {
		System.out.println(user.getFirstName());
		userService.addNewUser(user);
	}

}
