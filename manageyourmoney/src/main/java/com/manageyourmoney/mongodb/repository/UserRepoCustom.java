package com.manageyourmoney.mongodb.repository;

import com.manageyourmoney.mongodb.document.UserDocument;

public interface UserRepoCustom {
	
	UserDocument getUserByLogin(String userLogin);

}
