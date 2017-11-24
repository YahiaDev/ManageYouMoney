package com.manageyourmoney.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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

@Service
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
		List<PurchaseCategory> resultList = puchaseCatRepo.getPurchaseCatListByUser(idUser);
		return resultList != null ? resultList : new ArrayList<PurchaseCategory>();
	}

	public List<PurchaseCategory> getAllPurchaseCat() {
		List<PurchaseCategory> resultList = (List<PurchaseCategory>) puchaseCatRepo.findAll();
		return resultList != null ? resultList : new ArrayList<PurchaseCategory>();
	}

	public void deletePurchaseCat(PurchaseCategory purCat) {
		puchaseCatRepo.delete(purCat);
	}

	public void addPurchase(Purchase purchase) {
		purchaseRepo.save(purchase);
	}

	public List<Purchase> getAllPurchase() {
		List<Purchase> resultList = (List<Purchase>) purchaseRepo.findAll();
		return resultList != null ? resultList : new ArrayList<Purchase>();
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
