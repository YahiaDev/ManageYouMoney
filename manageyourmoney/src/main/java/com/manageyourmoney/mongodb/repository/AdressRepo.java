package com.manageyourmoney.mongodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manageyourmoney.mongodb.document.Adresse;

@Repository
public interface AdressRepo extends CrudRepository<Adresse, Long> {

}
