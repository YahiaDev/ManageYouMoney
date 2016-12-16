package com.manageyourmoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.common.Config;
import com.manageyourmoney.component.User;
import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private User user;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "login") String login, @RequestParam(value = "pwd") String pwd) {
		// User user = new User(12.0, "test", "1254", "yahia", "ammar");
		if (login.equals(new String("yahia.ammar.info@gmail.com"))) {

		} else {

		}
		user.setId(11);
		user.setName("yahia");
		user.setLogin("yahia.ammar.info@gmail.com");
		return user;
	}

	@RequestMapping(value = "addUser", method = RequestMethod.PUT)
	public void addNewUser(UserDocument newUser) {
		userService.addNewUser(newUser);
	}
}
