package com.manageyourmoney.mongodb.repository.impl;

import java.security.acl.Group;
import java.util.List;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.repository.PurchaseRepoCustom;
import com.mongodb.AggregationOptions;

public class PurchaseRepoImpl implements PurchaseRepoCustom{

	@Override
	public List<Purchase> getPurchaseGroupedByCategory() {
		// TODO Auto-generated method stub
		//Aggregation agg = new AggregationOptions(group())
		//group("aa		return null;
		return null;
	}

}
