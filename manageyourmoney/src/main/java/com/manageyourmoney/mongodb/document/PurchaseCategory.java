package com.manageyourmoney.mongodb.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Document(collection = "purchaseCategorie")
@EqualsAndHashCode
@ToString
public class PurchaseCategory {

	@Id
	private String categoryId;

	private String labelCat;

	private String description;

	@DBRef(db = "user")
	private UserDocument user;

	public PurchaseCategory() {
		super();
	}

	public PurchaseCategory(String categoryId, String labelCat, String description, UserDocument userDocument) {
		super();
		this.categoryId = categoryId;
		this.labelCat = labelCat;
		this.description = description;
		this.user = userDocument;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getLabelCat() {
		return labelCat;
	}

	public void setLabelCat(String labelCat) {
		this.labelCat = labelCat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDocument getUser() {
		return user;
	}

	public void setUser(UserDocument user) {
		this.user = user;
	}
	
}
