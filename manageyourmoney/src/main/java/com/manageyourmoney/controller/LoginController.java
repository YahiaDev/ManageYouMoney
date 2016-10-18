package com.manageyourmoney.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.common.Config;
import com.manageyourmoney.component.User;

@CrossOrigin(origins = Config.CROSS_URL)
@RestController
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<User> login(@RequestBody User user) {

		System.out.println("hello in login controller");
		if (user.getLogin() != null && user.getLogin().equals("yahia.ammar.info@gmail.com")) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
