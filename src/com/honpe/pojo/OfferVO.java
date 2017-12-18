package com.honpe.pojo;

import java.util.ArrayList;
import java.util.List;

public class OfferVO {
	private String 申请单号;
	private String 报价单号;
	private String 报价日期;
	private String 报价人;
	private String 供应商代码;
	private String 供应商名称;
	private String 报价金额;
	private String 交货日期;
	private List<OfferDetail> 报价明细 = new ArrayList<OfferDetail>();
	public String get申请单号() {
		return this.申请单号;
	}
	public void set申请单号(String 申请单号) {
		this.申请单号 = 申请单号;
	}
	public String get报价单号() {
		return this.报价单号;
	}
	public void set报价单号(String 报价单号) {
		this.报价单号 = 报价单号;
	}
	public String get报价日期() {
		return this.报价日期;
	}
	public void set报价日期(String 报价日期) {
		this.报价日期 = 报价日期;
	}
	public String get报价人() {
		return this.报价人;
	}
	public void set报价人(String 报价人) {
		this.报价人 = 报价人;
	}
	public String get供应商代码() {
		return this.供应商代码;
	}
	public void set供应商代码(String 供应商代码) {
		this.供应商代码 = 供应商代码;
	}
	public String get供应商名称() {
		return this.供应商名称;
	}
	public void set供应商名称(String 供应商名称) {
		this.供应商名称 = 供应商名称;
	}
	public String get报价金额() {
		return this.报价金额;
	}
	public void set报价金额(String 报价金额) {
		this.报价金额 = 报价金额;
	}
	public String get交货日期() {
		return this.交货日期;
	}
	public void set交货日期(String 交货日期) {
		this.交货日期 = 交货日期;
	}
	public List<OfferDetail> get报价明细() {
		return this.报价明细;
	}
	public void set报价明细(List<OfferDetail> 报价明细) {
		this.报价明细 = 报价明细;
	} 
}
