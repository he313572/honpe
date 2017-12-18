package com.honpe.pojo;

import com.honpe.po.TUser;

public class RegistData extends TUser {
	private String sid;

	private String company;

	private String fax;

	private String bank;

	private String bankNum;

	private String license;

	private String organize;

	private String tax;

	private Byte nullify;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid == null ? null : sid.trim();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax == null ? null : fax.trim();
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank == null ? null : bank.trim();
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum == null ? null : bankNum.trim();
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license == null ? null : license.trim();
	}

	public String getOrganize() {
		return organize;
	}

	public void setOrganize(String organize) {
		this.organize = organize == null ? null : organize.trim();
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax == null ? null : tax.trim();
	}

	public Byte getNullify() {
		return nullify;
	}

	public void setNullify(Byte nullify) {
		this.nullify = nullify;
	}
}
