package com.manageyourmoney.mongodb.repository;

import java.util.List;

import com.manageyourmoney.mongodb.document.Purchase;


public interface PurchaseRepoCustom {
	List<Purchase> getPurchaseGroupedByCategory();
}
