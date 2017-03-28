package com.manageyourmoney.mongodb.repository;

import java.util.List;

import com.manageyourmoney.mongodb.queryresult.PurchaseByCateg;
import com.manageyourmoney.mongodb.queryresult.PurchaseByDate;


public interface PurchaseRepoCustom {
	
	List<PurchaseByCateg> getPurchaseGroupedByCategory();
	
	List<PurchaseByDate> getPurchaseGroupedByDate();
}
