package com.manageyourmoney.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void addNewPurchaseCategories(@RequestParam(value = "catName") String catName,
			@RequestParam(value = "catDesc") String catDesc) {
		PurchaseCategories pc = new PurchaseCategories();
		ObjectId id = new ObjectId();
		pc.setCategoryId(id);
		pc.setDescription(catDesc);
		pc.setLabelCat(catName);
		purCatService.addPurchageCat(pc);
	}

}
