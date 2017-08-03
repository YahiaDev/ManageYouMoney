package com.manageyourmoney.mongodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manageyourmoney.mongodb.document.PurchaseCategory;

@Repository
public interface PurchaseCategoriesRepo extends CrudRepository<PurchaseCategory, String>, PurchaseCatRepoCustom {

}
