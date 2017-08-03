package com.manageyourmoney.mongodb.repository;

import java.util.List;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.document.PurchaseCategory;
import com.manageyourmoney.mongodb.queryresult.PurchaseByCateg;
import com.manageyourmoney.mongodb.queryresult.PurchaseByDate;

/**
 * @author Yahia
 *
 */
public interface PurchaseRepoCustom {

	/**
	 * @return List<PurchaseByCateg>
	 */
	List<PurchaseByCateg> getPurchaseGroupedByCategory();

	/**
	 * @return List<PurchaseByDate>
	 */
	List<PurchaseByDate> getPurchaseGroupedByDate();

	/**
	 * @param idUser
	 * @return List<Purchase>
	 */
	List<Purchase> getPurchaseListByIdUser(final String idUser);

}
