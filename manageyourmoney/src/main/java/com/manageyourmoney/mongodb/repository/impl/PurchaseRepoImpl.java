package com.manageyourmoney.mongodb.repository.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.expression.spel.ast.Projection;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.document.PurchaseByCateg;
import com.manageyourmoney.mongodb.repository.PurchaseRepoCustom;

public class PurchaseRepoImpl implements PurchaseRepoCustom {
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<PurchaseByCateg> getPurchaseGroupedByCategory() {
		Aggregation agg = newAggregation(group("category").sum("amount").as("count"),
				project("count").and("_id").as("category"));
		AggregationResults<PurchaseByCateg> groupResultByCategory = mongoTemplate.aggregate(agg, Purchase.class,
				PurchaseByCateg.class);
		List<PurchaseByCateg> purchaseByCategResult = groupResultByCategory.getMappedResults();
		return purchaseByCategResult;
	}

}
