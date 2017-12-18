package com.honpe.ext;

import java.util.List;

public class HistoryOfferExt {
	private String 驳回日期;
	private String 驳回原因;
	private List<HistoryOffer> 报价明细;

	public String get驳回日期() {
		return 驳回日期;
	}

	public void set驳回日期(String 驳回日期) {
		this.驳回日期 = 驳回日期;
	}

	public String get驳回原因() {
		return 驳回原因;
	}

	public void set驳回原因(String 驳回原因) {
		this.驳回原因 = 驳回原因;
	}

	public List<HistoryOffer> get报价明细() {
		return 报价明细;
	}

	public void set报价明细(List<HistoryOffer> 报价明细) {
		this.报价明细 = 报价明细;
	}
}
