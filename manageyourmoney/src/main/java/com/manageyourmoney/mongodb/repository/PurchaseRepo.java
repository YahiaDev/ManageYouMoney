package com.manageyourmoney.mongodb.repository;

import org.springframework.data.repository.CrudRepository;

import com.manageyourmoney.mongodb.document.Purchase;

/**
 * @author Yahia AMMAR
 *
 */
public interface PurchaseRepo extends CrudRepository<Purchase, String>, PurchaseRepoCustom {

}
