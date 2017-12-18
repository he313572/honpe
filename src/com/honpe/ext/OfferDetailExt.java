package com.honpe.ext;

import com.honpe.pojo.Product;

public class OfferDetailExt extends Product{
	private String 税率;
	private String 报价单价;
	public String get税率() {
		return this.税率;
	}
	public void set税率(String 税率) {
		this.税率 = 税率;
	}
	public String get报价单价() {
		return this.报价单价;
	}
	public void set报价单价(String 报价单价) {
		this.报价单价 = 报价单价;
	}
}
