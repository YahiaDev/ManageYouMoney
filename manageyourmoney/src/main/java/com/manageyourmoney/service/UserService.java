package com.manageyourmoney.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.mongodb.repository.UserRepo;

@Service
public class UserService {

	UserRepo userRepo;

	UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public void addNewUser(UserDocument newUser) {
		userRepo.save(newUser);
	}

	public List<UserDocument> getAllUser() {
		return (List<UserDocument>) userRepo.findAll();
	}

	public UserDocument getUserByLogin(String userLogin){
		return userRepo.getUserByLogin(userLogin);
	}
	
//	public void updateUser(UserDocument userDoc){
//		userRepo.save
//	}

}

