package com.manageyourmoney.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageyourmoney.mongodb.document.PurchaseCategories;
import com.manageyourmoney.mongodb.repository.PurchaseCategoriesRepo;

@Service
public class PurchaseCategoriesService {
	@Autowired
	PurchaseCategoriesRepo puchaseCatRepo;

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

}
