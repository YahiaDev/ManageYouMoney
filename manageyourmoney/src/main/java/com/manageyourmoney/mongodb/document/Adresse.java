package com.manageyourmoney.mongodb.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "adresse")
public class Adresse {

	@Id
	private long adresseId;
	private String adress;
	private String city;
	private String state;
	private long zipCode;

	public Adresse() {
		System.out.println("calling adresse default constructor");
	}

	@PersistenceConstructor
	public Adresse(long adresseId, String adress, String city, String state, long zipCode) {
		super();
		this.adresseId = adresseId;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public long getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(long adresseId) {
		this.adresseId = adresseId;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Adresse [adresseId=" + adresseId + ", adress=" + adress + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + (int) (adresseId ^ (adresseId >>> 32));
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + (int) (zipCode ^ (zipCode >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (adresseId != other.adresseId)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

}
