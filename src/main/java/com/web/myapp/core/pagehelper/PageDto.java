package com.web.myapp.core.pagehelper;

import java.util.ArrayList;
import java.util.List;

public class PageDto<T> {
    private int pageNo = 1; //页编号 : 第几页
    private int pageSize = 5; //页大小 : 每页的数量
    private int startRowNum; //偏移量 : 第一条数据在表中的位置
    private int totalCount; //总记录条数
    private int totalPages; //总页数
    private List<T> result = new ArrayList<T>(); //查询结果
    private String orderByCondition; //排序条件

    /**
     * @param totalCount 总记录条数
     */
    public PageDto(int totalCount) {
    	this.totalCount = totalCount;
        this.calcOffset();
        this.calcTotalPages();
    }
    
    /**
     * @param pageNo 当前第几页
     * @param pageSize 每页显示条数
     * @param totalCount 总记录条数
     */
    public PageDto(int pageNo, int pageSize,int totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.calcOffset();
        this.calcTotalPages();
    }
    
    /**
     * @param pageNo 当前第几页
     * @param pageSize 每页显示条数
     * @param totalCount 总记录条数
     * @param orderByCondition 排序条件
     */
    public PageDto(int pageNo, int pageSize,int totalCount,String orderByCondition) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.orderByCondition = orderByCondition;
        this.calcOffset();
        this.calcTotalPages();
    }
    
    /**
     * 计算偏移量
     */
    private void calcOffset() {
    	if(pageNo<1){
    		this.pageNo = 1;
    	}
    	if(pageSize<1){
    		this.pageSize = 5;
    	}
        this.startRowNum = ((pageNo - 1) * pageSize);
    }
    
    /**
     * 计算总页数
     * @return
     */
    private void calcTotalPages() {
        if (totalCount < 0) {
        	this.totalPages = -1;
        }
        int pages = totalCount / pageSize;
        this.totalPages = totalCount % pageSize > 0 ? ++pages : pages;
    }
    
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public String getOrderByCondition() {
		return orderByCondition;
	}
	public void setOrderByCondition(String orderByCondition) {
		this.orderByCondition = orderByCondition;
	}
	
	@Override
	public String toString() {
		return "PageDto [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", startRowNum=" + startRowNum + ", totalCount=" + totalCount
				+ ", totalPages=" + totalPages + ", result=" + result
				+ ", orderByCondition=" + orderByCondition + "]";
	}
}
