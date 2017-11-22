package com.manageyourmoney.service.impl;

import java.util.List;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.document.PurchaseCategory;
import com.manageyourmoney.mongodb.queryresult.PurchaseByCateg;
import com.manageyourmoney.mongodb.queryresult.PurchaseByDate;
import com.manageyourmoney.mongodb.repository.PurchaseCategoriesRepo;
import com.manageyourmoney.mongodb.repository.PurchaseRepo;
import com.manageyourmoney.service.PurchaseService;

/**
 * @author Yahia
 *
 */

public class PurchaseServiceImpl implements PurchaseService {

	PurchaseCategoriesRepo puchaseCatRepo;
	PurchaseRepo purchaseRepo;

	public PurchaseServiceImpl(PurchaseCategoriesRepo puchaseCatRepo, PurchaseRepo purchaseRepo) {
		super();
		this.puchaseCatRepo = puchaseCatRepo;
		this.purchaseRepo = purchaseRepo;
	}

	public void addPurchageCat(PurchaseCategory purCat) {
		puchaseCatRepo.save(purCat);
	}

	public void updatePurchageCat(PurchaseCategory purCat) {
		puchaseCatRepo.save(purCat);
	}

	public List<PurchaseCategory> getPurchaseCatByUser(String idUser) {
		return puchaseCatRepo.getPurchaseCatListByUser(idUser);
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

	public List<PurchaseByCateg> getPurchaseGroupedByCategory(final String idUser) {
		return purchaseRepo.getPurchaseGroupedByCategory(idUser);
	}

	public List<PurchaseByDate> getPurchaseGroupedByDate(final String idUser) {
		return purchaseRepo.getPurchaseGroupedByDate(idUser);
	}

	public List<Purchase> getPurchaseListByUserId(String idUser) {
		return purchaseRepo.getPurchaseListByIdUser(idUser);
	}

}
