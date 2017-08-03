package com.manageyourmoney.mongodb.repository;

import java.util.List;

import com.manageyourmoney.mongodb.document.Purchase;
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
	List<PurchaseByCateg> getPurchaseGroupedByCategory(final String idUser);

	/**
	 * @return List<PurchaseByDate>
	 */
	List<PurchaseByDate> getPurchaseGroupedByDate(final String idUser);

	/**
	 * @param idUser
	 * @return List<Purchase>
	 */
	List<Purchase> getPurchaseListByIdUser(final String idUser);

}
