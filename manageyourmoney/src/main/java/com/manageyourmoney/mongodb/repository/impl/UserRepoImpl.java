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
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("login").is(userLogin));
		UserDocument  userDoc = (UserDocument) mongoTemplate.findOne(query, UserDocument.class);
		return userDoc;
		// String criteria = "login="+userLogin;

		// UserDocument userDoc = new UserDocument();
		// userDoc.setLogin("yahia.ammar.info@gmail.com");
		// userDoc.setPassword("$2a$10$/vQPqzQqu2Vh.ch3/BhHyOoyY3TPJTNwB32Pd0brKq.4NudFHtjf6");
		// List<String> auth = new ArrayList<>();
		// auth.add("ADMIN");
		// userDoc.setAuthorities(auth);

		// query.addCriteria(Criteria.where(criteria).);
		// mongoTemplate.executeQuery(query, "", DocumentCallbackHandler);;
		// return userDoc;
	}

}
