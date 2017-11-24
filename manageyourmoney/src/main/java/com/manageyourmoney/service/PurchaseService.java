package com.manageyourmoney.service;

import java.util.List;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.document.PurchaseCategory;
import com.manageyourmoney.mongodb.queryresult.PurchaseByCateg;
import com.manageyourmoney.mongodb.queryresult.PurchaseByDate;

/**
 * @author Yahia AMMAR
 *
 */

public interface PurchaseService {

	void updatePurchageCat(PurchaseCategory purCat);

	List<PurchaseCategory> getPurchaseCatByUser(String idUser);

	List<PurchaseCategory> getAllPurchaseCat();

	void deletePurchaseCat(PurchaseCategory purCat);

	void addPurchase(Purchase purchase);

	List<Purchase> getAllPurchase();

	void updatePurchase(Purchase purchase);

	void deletePurchase(Purchase purchase);

	List<PurchaseByCateg> getPurchaseGroupedByCategory(final String idUser);

	List<PurchaseByDate> getPurchaseGroupedByDate(final String idUser);

	List<Purchase> getPurchaseListByUserId(String idUser);

	void addPurchageCat(PurchaseCategory purCat);

}
