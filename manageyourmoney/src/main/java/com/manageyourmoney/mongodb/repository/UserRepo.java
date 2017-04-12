package com.manageyourmoney.mongodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manageyourmoney.mongodb.document.UserDocument;

@Repository
public interface UserRepo extends CrudRepository<UserDocument, String>{

}
