package com.honpe.pojo;

import java.io.Serializable;

public class Demand implements Serializable {
	private String 申请单号;
	private String 申请日期;
	private String 特殊事项;
	private String 供应商确认;
	private String 供应商名称;
	private String 报价金额;
	private String 交货日期;
	private String 采购备注;
	private String 收货状态;
	private String 采购分类;
	private String 询价发布;

	public String get申请单号() {
		return this.申请单号;
	}

	public void set申请单号(String 申请单号) {
		this.申请单号 = 申请单号;
	}

	public String get申请日期() {
		return this.申请日期;
	}

	public void set申请日期(String 申请日期) {
		this.申请日期 = 申请日期;
	}

	public String get特殊事项() {
		return this.特殊事项;
	}

	public void set特殊事项(String 特殊事项) {
		this.特殊事项 = 特殊事项;
	}

	public String get供应商确认() {
		return this.供应商确认;
	}

	public void set供应商确认(String 供应商确认) {
		this.供应商确认 = 供应商确认;
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

	public String get采购备注() {
		return this.采购备注;
	}

	public void set采购备注(String 采购备注) {
		this.采购备注 = 采购备注;
	}

	public String get收货状态() {
		return this.收货状态;
	}

	public void set收货状态(String 收货状态) {
		this.收货状态 = 收货状态;
	}

	public String get采购分类() {
		return this.采购分类;
	}

	public void set采购分类(String 采购分类) {
		this.采购分类 = 采购分类;
	}

	public String get询价发布() {
		return this.询价发布;
	}

	public void set询价发布(String 询价发布) {
		this.询价发布 = 询价发布;
	}
}
