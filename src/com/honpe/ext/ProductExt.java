package com.honpe.ext;

import com.honpe.po.Offer;
import com.honpe.pojo.Product;

public class ProductExt extends Product {
	private Offer offer;
	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
