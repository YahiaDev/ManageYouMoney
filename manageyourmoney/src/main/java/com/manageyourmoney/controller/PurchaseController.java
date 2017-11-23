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
import com.manageyourmoney.service.impl.PurchaseServiceImpl;
import com.manageyourmoney.service.impl.UserServiceImpl;

/**
 * @author Yahia AMMAR
 *
 */
@RestController
@RequestMapping(value = "/api/purchase")
public class PurchaseController {

	PurchaseService purchaseService;

	UserServiceImpl userService;

	public PurchaseController(PurchaseServiceImpl purchaseService, UserServiceImpl userService) {
		this.purchaseService = purchaseService;
		this.userService = userService;
	}

	@RequestMapping(value = "/getAllPurchaseCategories", method = RequestMethod.GET)
	public List<PurchaseCategory> getAllPurchaseCategories(@RequestParam(name = "userId") String userId) {
		return purchaseService.getPurchaseCatByUser(userId);
	}

	@RequestMapping(value = "/addPurchaseCategories", method = RequestMethod.PUT)
	public List<PurchaseCategory> addNewPurchaseCategories(@RequestBody PurchaseCategory purchaseCat) {
		purchaseService.addPurchageCat(purchaseCat);
		return purchaseService.getPurchaseCatByUser(purchaseCat.getUser().getId());
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
	public List<Purchase> getAllPurchase(@RequestParam(name = "userId") String userId) {
		return purchaseService.getPurchaseListByUserId(userId);
	}

	@RequestMapping(value = "/addPurchase", method = RequestMethod.PUT)
	public List<Purchase> addNewPurchase(@RequestBody Purchase purchase) {
		purchaseService.addPurchase(purchase);
		return purchaseService.getPurchaseListByUserId(purchase.getUser().getId());
	}

	@RequestMapping(value = "/updatePurchase", method = RequestMethod.POST)
	public List<Purchase> updatePurchases(@RequestBody Purchase purchase) {
		purchaseService.updatePurchase(purchase);
		return purchaseService.getPurchaseListByUserId(purchase.getUser().getId());
	}

	@RequestMapping(value = "/deletePurchase", method = RequestMethod.POST)
	public List<Purchase> deletePurchaseCategories(@RequestBody Purchase purchase) {
		purchaseService.deletePurchase(purchase);
		return purchaseService.getAllPurchase();
	}

	@RequestMapping(value = "/getPurchaseGroupedByCateg", method = RequestMethod.GET)
	public List<PurchaseByCateg> getPurchaseByCateg(@RequestParam(name = "userId") String userId) {
		return purchaseService.getPurchaseGroupedByCategory(userId);
	}

	@RequestMapping(value = "/getPurchaseGroupedByDate", method = RequestMethod.GET)
	public List<PurchaseByDate> getPurchaseByDate(@RequestParam(name = "userId") String userId) {
		return purchaseService.getPurchaseGroupedByDate(userId);
	}
}
