package com.manageyourmoney.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.common.Config;
import com.manageyourmoney.dto.LoginDTO;
import com.manageyourmoney.dto.UserDTO;
import com.manageyourmoney.service.AuthenticationService;

//@CrossOrigin(origins = Config.CROSS_URL)
@RestController
@RequestMapping(value = "/api")
public class Authentication {

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public UserDTO authenticate(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws Exception {
		UserDTO userDto = authenticationService.authenticate(loginDTO, response);
		return userDto;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception {
		System.out.println("yahia ammmaraaaaaa");
		return new String("ammar");
	}
}
