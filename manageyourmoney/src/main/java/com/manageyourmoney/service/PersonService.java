package com.manageyourmoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageyourmoney.mongodb.document.Person;
import com.manageyourmoney.mongodb.repository.PersonRepo;

@Service
public class PersonService {
	@Autowired
	private PersonRepo personRepo;

	public void savePerson(Person person) {
		personRepo.save(person);
	}

	public Iterable<Person> findAll() throws Exception {
		try {
			return personRepo.findAll();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
