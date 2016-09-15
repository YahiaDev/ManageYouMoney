package com.manageyourmoney.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.component.User;

@RestController
@RequestMapping("/User")
public class UserController {
	@RequestMapping(value="getUser", method= RequestMethod.GET,headers="Accept=application/json")
	public User getUser() {
		User user = new User(12.0, "test", "1254", "yahia", "ammar");
		return user;
	}
}
