package com.manageyourmoney.mongodb.repository.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.queryresult.PurchaseByCateg;
import com.manageyourmoney.mongodb.queryresult.PurchaseByDate;
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

	@Override
	public List<PurchaseByDate> getPurchaseGroupedByDate() {
		Aggregation agg = newAggregation(project().and("amount").as("amount").and("date").extractYear().as("year")
				.and("date").extractMonth().as("month"), group("year", "month").sum("amount").as("amount"));
		AggregationResults<PurchaseByDate> groupResultByCategory = mongoTemplate.aggregate(agg, Purchase.class,
				PurchaseByDate.class);
		List<PurchaseByDate> purchaseByCategResult = groupResultByCategory.getMappedResults();
		return purchaseByCategResult;
	}

}
