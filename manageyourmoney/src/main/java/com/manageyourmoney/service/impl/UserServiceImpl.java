package com.manageyourmoney.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.manageyourmoney.exeption.UserExitsException;
import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.mongodb.repository.UserRepo;
import com.manageyourmoney.service.UserService;


public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;

	// public UserService(UserRepo userRepo, InMemoryUserDetailsManager
	// inMemoryUserDetailsManager) {
	// this.userRepo = userRepo;
	// this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
	// }

	public void addNewUser(UserDocument newUser) throws UserExitsException {
		boolean userExists = inMemoryUserDetailsManager.userExists(newUser.getLogin());
		if (!userExists) {
			inMemoryUserDetailsManager
					.createUser(new User(newUser.getLogin(), newUser.getPassword(), new ArrayList<GrantedAuthority>()));
			userRepo.save(newUser);

		} else {
			throw new UserExitsException("user is already exists");
		}
	}

	public List<UserDocument> getAllUser() {
		return (List<UserDocument>) userRepo.findAll();
	}

	public UserDocument getUserByLogin(String userLogin) {
		return userRepo.getUserByLogin(userLogin);
	}

}
