package com.manageyourmoney.mongodb.document;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personne")
public class Person {
	@Id
	private long personneId;

	private String name;

	private int password;

	@DBRef(db = "adress")
	private List<Adresse> addresses = new ArrayList<>();

	public Person() {
	}

	@PersistenceConstructor
	public Person(long personneId, String name, int password, List<Adresse> addresses) {
		super();
		this.personneId = personneId;
		this.name = name;
		this.password = password;
		this.addresses = addresses;
	}

	public long getPersonneId() {
		return personneId;
	}

	public void setPersonneId(long personneId) {
		this.personneId = personneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public List<Adresse> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Adresse> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Person [personneId=" + personneId + ", name=" + name + ", password=" + password + ", addresses="
				+ addresses + "]";
	}

}
