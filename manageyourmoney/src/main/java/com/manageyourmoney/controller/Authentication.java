package com.manageyourmoney.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.service.AuthenticationService;

@RestController
@RequestMapping(value = "/api")
public class Authentication {

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.PUT)
	public UserDocument authenticate(@RequestBody UserDocument userDocument, HttpServletResponse response) throws Exception {
		try {
			UserDocument userDto = authenticationService.authenticate(userDocument, response);
			return userDto;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
		authenticationService.logout();
	}
}
