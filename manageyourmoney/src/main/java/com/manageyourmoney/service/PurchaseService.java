package com.manageyourmoney.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.document.PurchaseCategory;
import com.manageyourmoney.mongodb.queryresult.PurchaseByCateg;
import com.manageyourmoney.mongodb.queryresult.PurchaseByDate;
import com.manageyourmoney.mongodb.repository.PurchaseCategoriesRepo;
import com.manageyourmoney.mongodb.repository.PurchaseRepo;

@Service
public class PurchaseService {
	@Autowired
	PurchaseCategoriesRepo puchaseCatRepo;

	@Autowired
	PurchaseRepo purchaseRepo;

	public void addPurchageCat(PurchaseCategory purCat) {
		puchaseCatRepo.save(purCat);
	}

	public void updatePurchageCat(PurchaseCategory purCat) {
		puchaseCatRepo.save(purCat);
	}

	public List<PurchaseCategory> getAllPurchaseCat() {
		return (List<PurchaseCategory>) puchaseCatRepo.findAll();
	}

	public void deletePurchaseCat(PurchaseCategory purCat) {
		puchaseCatRepo.delete(purCat);
	}

	public void addPurchase(Purchase purchase) {
		purchaseRepo.save(purchase);
	}

	public List<Purchase> getAllPurchase() {
		return (List<Purchase>) purchaseRepo.findAll();
	}

	public void updatePurchase(Purchase purchase) {
		purchaseRepo.save(purchase);
	}

	public void deletePurchase(Purchase purchase) {
		purchaseRepo.delete(purchase);
	}

	public List<PurchaseByCateg> getPurchaseGroupedByCategory() {
		return purchaseRepo.getPurchaseGroupedByCategory();
	}
	
	public List<PurchaseByDate> getPurchaseGroupedByDate() {
		return purchaseRepo.getPurchaseGroupedByDate();
	}

}
