package com.manageyourmoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.mongodb.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public void addNewUser(UserDocument newUser) {
		userRepo.save(newUser);
	}

}
