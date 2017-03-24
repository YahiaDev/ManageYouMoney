package com.manageyourmoney.mongodb.repository;

import java.util.List;

import com.manageyourmoney.mongodb.document.PurchaseByCateg;


public interface PurchaseRepoCustom {
	
	List<PurchaseByCateg> getPurchaseGroupedByCategory();
}
