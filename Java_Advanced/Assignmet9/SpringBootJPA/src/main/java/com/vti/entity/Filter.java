package com.vti.entity;

public class Filter {
	private int minMember;
	private int maxMember;
	
	private int page;
	private int pageSize;
	
	private String field;
	private String type;//asc,desc
	
	
	public Filter() {
		
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMinMember() {
		return minMember;
	}
	public void setMinMember(int minMember) {
		this.minMember = minMember;
	}
	public int getMaxMember() {
		return maxMember;
	}
	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}

	@Override
	public String toString() {
		return "Filter [minMember=" + minMember + ", maxMember=" + maxMember + ", page=" + page + ", pageSize="
				+ pageSize + ", field=" + field + ", type=" + type + "]";
	}
	
	
}
