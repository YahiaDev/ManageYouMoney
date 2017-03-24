package com.manageyourmoney.mongodb.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "purchaseCategorie")
public class PurchaseCategory {

	@Id
	private String categoryId;

	private String labelCat;

	private String description;

	public PurchaseCategory() {
		super();
	}

	public PurchaseCategory(String categoryId, String labelCat, String description) {
		super();
		this.categoryId = categoryId;
		this.labelCat = labelCat;
		this.description = description;
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

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((labelCat == null) ? 0 : labelCat.hashCode());
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
		PurchaseCategory other = (PurchaseCategory) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (labelCat == null) {
			if (other.labelCat != null)
				return false;
		} else if (!labelCat.equals(other.labelCat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseCategories [categoryId=" + categoryId + ", labelCat=" + labelCat + ", description="
				+ description + "]";
	}

}
