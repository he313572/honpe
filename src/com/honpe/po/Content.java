package com.honpe.po;

import java.util.Date;

public class Content {
	private Integer cid;

	private Integer caid;

	private String contentname;

	private String contenttitle;

	private Date createtime;

	private Date updatetime;

	private String content;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCaid() {
		return caid;
	}

	public void setCaid(Integer caid) {
		this.caid = caid;
	}

	public String getContentname() {
		return contentname;
	}

	public void setContentname(String contentname) {
		this.contentname = contentname == null ? null : contentname.trim();
	}

	public String getContenttitle() {
		return contenttitle;
	}

	public void setContenttitle(String contenttitle) {
		this.contenttitle = contenttitle == null ? null : contenttitle.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}