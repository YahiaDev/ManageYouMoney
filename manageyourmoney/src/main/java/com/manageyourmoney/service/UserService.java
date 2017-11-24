package com.manageyourmoney.service;

import java.util.List;

import com.manageyourmoney.exeption.UserExitsException;
import com.manageyourmoney.mongodb.document.UserDocument;

/**
 * @author Yahia AMMAR
 *
 */

public interface UserService {

	void addNewUser(UserDocument newUser) throws UserExitsException;

	List<UserDocument> getAllUser();

	UserDocument getUserByLogin(String userLogin);

}
