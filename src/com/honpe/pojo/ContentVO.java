package com.honpe.pojo;

import java.util.List;

import com.honpe.po.Content;
/**
 * 内容返回json包装pojo
 * @author Administrator
 *
 */
public class ContentVO {
	private List<Content> group1;
	private List<Content> group2;
	private List<Content> group3;

	public List<Content> getGroup1() {
		return this.group1;
	}

	public void setGroup1(List<Content> group1) {
		this.group1 = group1;
	}

	public List<Content> getGroup2() {
		return this.group2;
	}

	public void setGroup2(List<Content> group2) {
		this.group2 = group2;
	}

	public List<Content> getGroup3() {
		return this.group3;
	}

	public void setGroup3(List<Content> group3) {
		this.group3 = group3;
	}

}
