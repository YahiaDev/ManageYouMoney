package com.manageyourmoney.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.dto.Profile;
import com.manageyourmoney.dto.UserDTO;
import com.manageyourmoney.mock.MockUsers;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class Users {

	@RequestMapping("/users")
	public List<UserDTO> query() {
		return MockUsers.getUsers();
	}

	@RequestMapping("/users/{id}")
	public UserDTO query(@PathVariable Integer id) {
		return MockUsers.findById(id);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public UserDTO update(@RequestBody @Valid UserDTO userDTO) {
		return MockUsers.update(userDTO);
	}

	@RequestMapping("/users/profiles")
	public List<String> getProfiles() {
		List<String> profiles = new ArrayList<String>();
		for (Profile profile : Profile.values()) {
			profiles.add(profile.name());
		}
		return profiles;
	}
}
