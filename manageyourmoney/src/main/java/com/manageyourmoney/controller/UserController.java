package com.manageyourmoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.component.User;

@RestController
public class UserController {
	@Autowired
	private User user;
	@RequestMapping(value="getUser", method= RequestMethod.GET,headers="Accept=application/json")
	public User getUser() {
		//User user = new User(12.0, "test", "1254", "yahia", "ammar");
		user.setId(11);
		user.setName("yahia");
		user.setLogin("yahia.ammar.info@gmail.com");
		return user;
	}
}
