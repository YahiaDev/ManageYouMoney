package com.manageyourmoney.mongodb.document;

public class PurchaseByCateg {

	private PurchaseCategory category;
	private long count;

	public PurchaseByCateg() {
		super();
	}

	public PurchaseByCateg(PurchaseCategory category, long count) {
		super();
		this.category = category;
		this.count = count;
	}

	public PurchaseCategory getcategory() {
		return category;
	}

	public void setcategory(PurchaseCategory category) {
		this.category = category;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	// public long getAmount() {
	// return amount;
	// }
	//
	// public void setAmount(long amount) {
	// this.amount = amount;
	// }

}
