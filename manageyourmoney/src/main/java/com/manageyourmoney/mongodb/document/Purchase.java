package com.manageyourmoney.mongodb.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "purchase")
public class Purchase {

	@Id
	private String idPurchase;
	private Date date;
	private double amount;
	private String label;
	private String comment;

	@DBRef(db = "purchaseCategorie")
	private PurchaseCategories categorie;

	public Purchase() {
		super();
	}

	public Purchase(String idPurchase, Date date, double amount, String label, String comment,
			PurchaseCategories categorie) {
		super();
		this.idPurchase = idPurchase;
		this.date = date;
		this.amount = amount;
		this.label = label;
		this.comment = comment;
		this.categorie = categorie;
	}

	public String getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(String idPurchase) {
		this.idPurchase = idPurchase;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public PurchaseCategories getCategorie() {
		return categorie;
	}

	public void setCategorie(PurchaseCategories categorie) {
		this.categorie = categorie;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((idPurchase == null) ? 0 : idPurchase.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Purchase other = (Purchase) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idPurchase == null) {
			if (other.idPurchase != null)
				return false;
		} else if (!idPurchase.equals(other.idPurchase))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Purchase [idPurchase=" + idPurchase + ", date=" + date + ", price=" + amount + ", label=" + label
				+ ", comment=" + comment + "]";
	}

}
