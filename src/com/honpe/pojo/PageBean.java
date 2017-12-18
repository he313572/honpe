package com.honpe.pojo;
import java.util.List;

public class PageBean<T> {
	private int currentPage;// 当前页
	private int totalRecord;// 记录总数
	private int pageSize;// 每页显示记录数
	private int totalPage;// 总共页数
	private List<T> data;// 数据

	private int start;// 起始页
	private int end;// 终止页

	public PageBean() {

	}

	public PageBean(int currentPage, int totalRecord, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
		this.start = 1;
		this.end = 10;
		if (this.totalPage <= 10) {
			this.end = this.totalPage;
		} else {
			this.start = this.currentPage - 4;
			this.end = this.currentPage + 5;

			if (this.start < 1) {
				this.start = 1;
				this.end = 10;
			}
			if (this.end > this.totalPage) {
				this.end = this.totalPage;
				this.start = this.totalPage - 9;
			}
		}

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
