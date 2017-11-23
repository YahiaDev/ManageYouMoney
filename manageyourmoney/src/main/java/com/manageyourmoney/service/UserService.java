package com.manageyourmoney.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manageyourmoney.exeption.UserExitsException;
import com.manageyourmoney.mongodb.document.UserDocument;

/**
 * @author Yahia AMMAR
 *
 */
@Service
public interface UserService {
	
	void addNewUser(UserDocument newUser) throws UserExitsException;
	
	List<UserDocument> getAllUser();
	
	UserDocument getUserByLogin(String userLogin);

}
