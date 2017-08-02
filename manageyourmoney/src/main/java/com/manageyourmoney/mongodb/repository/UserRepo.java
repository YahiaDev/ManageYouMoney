package com.manageyourmoney.mongodb.repository;

import org.springframework.data.repository.CrudRepository;

import com.manageyourmoney.mongodb.document.UserDocument;


public interface UserRepo extends CrudRepository<UserDocument, String>, UserRepoCustom {

}