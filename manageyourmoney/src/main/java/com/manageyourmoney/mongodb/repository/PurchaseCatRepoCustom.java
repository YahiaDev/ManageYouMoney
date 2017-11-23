package com.manageyourmoney.mongodb.repository;

import java.util.List;

import com.manageyourmoney.mongodb.document.PurchaseCategory;

/**
 * @author Yahia AMMAR
 *
 */
public interface PurchaseCatRepoCustom {
	
	/**
	 * @param idUser
	 * @return List<PurchaseCategory> getPurchaseCatListByIdUser
	 */
	List<PurchaseCategory> getPurchaseCatListByUser(final String idUser);

}
