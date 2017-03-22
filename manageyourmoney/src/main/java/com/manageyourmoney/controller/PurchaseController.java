package com.manageyourmoney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.document.PurchaseCategories;
import com.manageyourmoney.service.PurchaseService;

@RestController
@RequestMapping(value = "/api/purchase")
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	@RequestMapping(value = "/getAllPurchaseCategories", method = RequestMethod.GET)
	public List<PurchaseCategories> getAllPurchaseCategories() {
		return purchaseService.getAllPurchaseCat();
	}

	@RequestMapping(value = "/addPurchaseCategories", method = RequestMethod.PUT)
	public List<PurchaseCategories> addNewPurchaseCategories(@RequestParam(value = "catName") String catName,
			@RequestParam(value = "catDesc") String catDesc) {
		PurchaseCategories pc = new PurchaseCategories();
		pc.setDescription(catDesc);
		pc.setLabelCat(catName);
		purchaseService.addPurchageCat(pc);
		return purchaseService.getAllPurchaseCat();
	}

	@RequestMapping(value = "/updatePurchaseCategories", method = RequestMethod.POST)
	public void updatePurchaseCategories(@RequestBody PurchaseCategories purCat) {
		purchaseService.updatePurchageCat(purCat);
	}

	@RequestMapping(value = "/deletePurchaseCategories", method = RequestMethod.POST)
	public List<PurchaseCategories> deletePurchaseCategories(@RequestBody PurchaseCategories purCat) {
		purchaseService.deletePurchaseCat(purCat);
		return purchaseService.getAllPurchaseCat();
	}

	@RequestMapping(value = "/getAllPurchase", method = RequestMethod.GET)
	public List<Purchase> getAllPurchase() {
		return purchaseService.getAllPurchase();
	}

	@RequestMapping(value = "/addPurchase", method = RequestMethod.PUT)
	public List<Purchase> addNewPurchaseCategories(@RequestBody Purchase purchase) {
		purchaseService.addPurchase(purchase);
		return purchaseService.getAllPurchase();
	}

	@RequestMapping(value = "/updatePurchase", method = RequestMethod.POST)
	public List<Purchase> updatePurchases(@RequestBody Purchase purchase) {
		purchaseService.updatePurchase(purchase);
		return purchaseService.getAllPurchase();
	}

	@RequestMapping(value = "/deletePurchase", method = RequestMethod.POST)
	public List<Purchase> deletePurchaseCategories(@RequestBody Purchase purchase) {
		purchaseService.deletePurchase(purchase);
		return purchaseService.getAllPurchase();
	}

}
