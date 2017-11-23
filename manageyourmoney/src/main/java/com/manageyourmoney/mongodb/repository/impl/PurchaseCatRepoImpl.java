package com.manageyourmoney.mongodb.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.manageyourmoney.mongodb.document.PurchaseCategory;
import com.manageyourmoney.mongodb.repository.PurchaseCatRepoCustom;

/**
 * @author Yahia AMMAR
 *
 */
public class PurchaseCatRepoImpl implements PurchaseCatRepoCustom {

	MongoTemplate mongoTemplate;

	public PurchaseCatRepoImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<PurchaseCategory> getPurchaseCatListByUser(String idUser) {
		List<PurchaseCategory> purchaseCatList = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("user.id").is(idUser));
		purchaseCatList = mongoTemplate.find(query, PurchaseCategory.class);
		return purchaseCatList == null ? new ArrayList<PurchaseCategory>() : purchaseCatList;
	}

}
