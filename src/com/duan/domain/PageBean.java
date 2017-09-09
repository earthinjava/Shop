package com.duan.domain;

import java.util.List;

public class PageBean {
	//存储元素select * from product where cid=? limit pageNumber*pageSize-pageSize+1,pageNumber*pageSize
	private List<Product> data;
	//当前页码
	private int pageNumber;
	//总记录select * from product where cid=? 获得后++
	private int totalRecord;
	//每页显示数量
	private int pageSize;
	//总页数 totalRecod/pageNumber==0?toatalRecod/pageNumber:....+1
	private int totalPage;
	
	public List<Product> getData() {
		return data;
	}
	public void setData(List<Product> data) {
		this.data = data;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
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
	
}
