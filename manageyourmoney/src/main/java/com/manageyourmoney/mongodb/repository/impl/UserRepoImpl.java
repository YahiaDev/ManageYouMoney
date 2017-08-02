package com.manageyourmoney.mongodb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.mongodb.repository.UserRepoCustom;

public class UserRepoImpl implements UserRepoCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public UserDocument getUserByLogin(String userLogin) {
		Query query = new Query();
		query.addCriteria(Criteria.where("login").is(userLogin));
		UserDocument userDocument = new UserDocument();
		userDocument = (UserDocument) mongoTemplate.findOne(query, UserDocument.class);
		return userDocument;
	}

}
