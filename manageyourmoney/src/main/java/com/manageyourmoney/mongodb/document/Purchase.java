package com.manageyourmoney.mongodb.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Yahia AMMAR
 *
 */
@Document(collection = "purchase")
@EqualsAndHashCode
@ToString
public class Purchase {

	@Id
	private String idPurchase;
	private Date date;
	private double amount;
	private String label;
	private String comment;

	@DBRef(db = "purchaseCategorie")
	private PurchaseCategory category;

	@DBRef(db = "user")
	private UserDocument user;

	public Purchase() {
		super();
	}

	public Purchase(String idPurchase, Date date, double amount, String label, String comment,
			PurchaseCategory category, UserDocument user) {
		super();
		this.idPurchase = idPurchase;
		this.date = date;
		this.amount = amount;
		this.label = label;
		this.comment = comment;
		this.category = category;
		this.user = user;
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

	public PurchaseCategory getCategory() {
		return category;
	}

	public void setCategory(PurchaseCategory categorie) {
		this.category = categorie;
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

	public UserDocument getUser() {
		return user;
	}

	public void setUser(UserDocument user) {
		this.user = user;
	}

}
