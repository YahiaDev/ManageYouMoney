package com.manageyourmoney.mongodb.repository;

import com.manageyourmoney.mongodb.document.UserDocument;

/**
 * @author Yahia AMMAR
 *
 */
public interface UserRepoCustom {
	
	UserDocument getUserByLogin(String userLogin);

}
