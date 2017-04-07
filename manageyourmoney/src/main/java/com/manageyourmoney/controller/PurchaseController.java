package com.manageyourmoney.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.document.PurchaseCategory;
import com.manageyourmoney.mongodb.queryresult.PurchaseByCateg;
import com.manageyourmoney.mongodb.queryresult.PurchaseByDate;
import com.manageyourmoney.service.PurchaseService;

@RestController
@RequestMapping(value = "/api/purchase")
public class PurchaseController {

	PurchaseService purchaseService;

	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@RequestMapping(value = "/getAllPurchaseCategories", method = RequestMethod.GET)
	public List<PurchaseCategory> getAllPurchaseCategories() {
		return purchaseService.getAllPurchaseCat();
	}

	@RequestMapping(value = "/addPurchaseCategories", method = RequestMethod.PUT)
	public List<PurchaseCategory> addNewPurchaseCategories(@RequestParam(value = "catName") String catName,
			@RequestParam(value = "catDesc") String catDesc) {
		PurchaseCategory pc = new PurchaseCategory();
		pc.setDescription(catDesc);
		pc.setLabelCat(catName);
		purchaseService.addPurchageCat(pc);
		return purchaseService.getAllPurchaseCat();
	}

	@RequestMapping(value = "/updatePurchaseCategories", method = RequestMethod.POST)
	public void updatePurchaseCategories(@RequestBody PurchaseCategory purCat) {
		purchaseService.updatePurchageCat(purCat);
	}

	@RequestMapping(value = "/deletePurchaseCategories", method = RequestMethod.POST)
	public List<PurchaseCategory> deletePurchaseCategories(@RequestBody PurchaseCategory purCat) {
		purchaseService.deletePurchaseCat(purCat);
		return purchaseService.getAllPurchaseCat();
	}

	@RequestMapping(value = "/getAllPurchase", method = RequestMethod.GET)
	public List<Purchase> getAllPurchase() {
		// purchaseService.getAllPurchase().stream()
		// .filter(p -> p.getCategory().getLabelCat().equals(new
		// String("Cinema"))).collect(Collectors.toList());
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

	@RequestMapping(value = "/getPurchaseGroupedByCateg", method = RequestMethod.GET)
	public List<PurchaseByCateg> getPurchaseByCateg() {
		return purchaseService.getPurchaseGroupedByCategory();
	}

	@RequestMapping(value = "/getPurchaseGroupedByDate", method = RequestMethod.GET)
	public List<PurchaseByDate> getPurchaseByDate() {
		return purchaseService.getPurchaseGroupedByDate();
	}
}
