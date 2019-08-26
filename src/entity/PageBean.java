package entity;

import java.util.List;

public class PageBean<T> {
	private int currentPage = 1;//当前页
	private int pageSize = 3;//每页记录数
	private int totalCount = 0 ; //总记录数
	private int totalPage = 0; //总页数
	private int startNum = 0;//开始行号: (当前页-1)*每页记录数
	private int endNum = 0; //结束行号 :当前页*每页记录数 + 1
	private List<T> pageData; //结果集
	public int getStartNum() {//计算开始行号
		return (this.currentPage-1)*this.pageSize;
	}
	public int getEndNum() {//计算结束行号
		return this.currentPage*this.pageSize +1;
	}
	public int getTotalPage() {
		totalPage = totalCount / pageSize;
		if (totalCount == 0 || totalCount% pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


}
