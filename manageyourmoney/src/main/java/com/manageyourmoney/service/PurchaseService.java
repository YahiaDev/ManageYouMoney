package com.manageyourmoney.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.document.PurchaseCategories;
import com.manageyourmoney.mongodb.repository.PurchaseCategoriesRepo;
import com.manageyourmoney.mongodb.repository.PurchaseRepo;

@Service
public class PurchaseService {
	@Autowired
	PurchaseCategoriesRepo puchaseCatRepo;

	@Autowired
	PurchaseRepo purchaseRepo;

	public void addPurchageCat(PurchaseCategories purCat) {
		puchaseCatRepo.save(purCat);
	}

	public void updatePurchageCat(PurchaseCategories purCat) {
		puchaseCatRepo.save(purCat);
	}

	public List<PurchaseCategories> getAllPurchaseCat() {
		return (List<PurchaseCategories>) puchaseCatRepo.findAll();
	}

	public void deletePurchaseCat(PurchaseCategories purCat) {
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
	
	
	public void getPurchaseGroupedByCategory(){
		purchaseRepo.getPurchaseGroupedByCategory();
	}

}
