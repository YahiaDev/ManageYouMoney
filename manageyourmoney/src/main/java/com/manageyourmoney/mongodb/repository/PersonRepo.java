package com.manageyourmoney.mongodb.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manageyourmoney.mongodb.document.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {

	@Query("{'name' : ?0}")
	public Iterable<Person> searchByName(String personName);

}
