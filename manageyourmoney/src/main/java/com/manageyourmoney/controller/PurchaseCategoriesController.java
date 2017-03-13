package com.manageyourmoney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.mongodb.document.PurchaseCategories;
import com.manageyourmoney.service.PurchaseCategoriesService;

@RestController
@RequestMapping(value = "/api/purchase")
public class PurchaseCategoriesController {

	@Autowired
	PurchaseCategoriesService purCatService;

	@RequestMapping(value = "/getAllPurchaseCategories", method = RequestMethod.GET)
	public List<PurchaseCategories> getAllPurchaseCategories() {
		return purCatService.getAllPurchaseCat();
	}

	@RequestMapping(value = "/addPurchaseCategories", method = RequestMethod.PUT)
	public List<PurchaseCategories> addNewPurchaseCategories(@RequestParam(value = "catName") String catName,
			@RequestParam(value = "catDesc") String catDesc) {
		PurchaseCategories pc = new PurchaseCategories();
		pc.setDescription(catDesc);
		pc.setLabelCat(catName);
		purCatService.addPurchageCat(pc);
		return purCatService.getAllPurchaseCat();
	}

	@RequestMapping(value = "/updatePurchaseCategories", method = RequestMethod.POST)
	public void updatePurchaseCategories(@RequestBody PurchaseCategories purCat) {
		purCatService.updatePurchageCat(purCat);
	}

	@RequestMapping(value = "/deletePurchaseCategories", method = RequestMethod.POST)
	public List<PurchaseCategories> deletePurchaseCategories(@RequestBody PurchaseCategories purCat) {
		purCatService.deletePurchaseCat(purCat);
		return purCatService.getAllPurchaseCat();
	}

}
