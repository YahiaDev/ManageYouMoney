package com.manageyourmoney.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.dto.Profile;

@RestController
@RequestMapping(value = "/api")
public class Users {

	@RequestMapping("/users/profiles")
	public List<String> getProfiles() {
		List<String> profiles = new ArrayList<String>();
		for (Profile profile : Profile.values()) {
			profiles.add(profile.name());
		}
		return profiles;
	}
}
