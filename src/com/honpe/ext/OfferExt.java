package com.honpe.ext;

import com.honpe.pojo.OfferVO;

public class OfferExt extends OfferVO {
	private String 采购驳回;
	private String 驳回人;
	private String 驳回日期;
	private String 驳回原因;
	private String 中标状态;

	public String get采购驳回() {
		return this.采购驳回;
	}

	public void set采购驳回(String 采购驳回) {
		this.采购驳回 = 采购驳回;
	}

	public String get驳回人() {
		return this.驳回人;
	}

	public void set驳回人(String 驳回人) {
		this.驳回人 = 驳回人;
	}

	public String get驳回日期() {
		return this.驳回日期;
	}

	public void set驳回日期(String 驳回日期) {
		this.驳回日期 = 驳回日期;
	}

	public String get驳回原因() {
		return this.驳回原因;
	}

	public void set驳回原因(String 驳回原因) {
		this.驳回原因 = 驳回原因;
	}

	public String get中标状态() {
		return this.中标状态;
	}

	public void set中标状态(String 中标状态) {
		this.中标状态 = 中标状态;
	}
}
