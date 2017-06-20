package com.manageyourmoney.mongodb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.mongodb.repository.UserRepoCustom;

public class UserRepoImpl implements UserRepoCustom {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public UserDocument getUserByLogin(String userLogin) {
		// TODO Auto-generated method stub
		return null;
	}

}
