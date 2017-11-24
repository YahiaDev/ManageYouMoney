package com.manageyourmoney.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.manageyourmoney.exeption.UserExitsException;
import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.mongodb.repository.UserRepo;
import com.manageyourmoney.service.UserService;

/**
 * @author Yahia AMMAR
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;

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
		List<UserDocument> listResult = (List<UserDocument>) userRepo.findAll();
		return listResult != null ? listResult : new ArrayList<UserDocument>();
	}

	public UserDocument getUserByLogin(String userLogin) {
		UserDocument user = userRepo.getUserByLogin(userLogin);
		return user != null ? user : new UserDocument();
	}

}
