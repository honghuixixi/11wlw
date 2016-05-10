package com.qpwa.mongo.util;

import java.util.List;

public class Page<T> {

	/** 每页显示条数 */
	private Integer pageSize = 8;

	/** 当前页 */
	private Integer currentPage = 1;

	/** 总页数 */
	private Integer totalPage = 1;

	/** 查询到的总数据量 */
	private Long totalNumber = 0l;

	/** 数据集 */
	private List<T> items;

	
	public Page(Integer pageSize, Integer currentPage, Long totalNumber,Integer totalPage) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalNumber = totalNumber;
		this.totalPage = totalPage;
	}

	public Page() {
		super();
	}

	public Integer getPageSize() {

		return pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
