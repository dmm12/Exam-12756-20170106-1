package com.ssm.uitl;


public class PageUtil {
	private int  pageSize; //每页要显示的条数
	private int  recordCount; //总共的条数
	private int  currentPage;//当前页数
	
	public int getPageCount(){//获得最后一页
	 int size  = recordCount / pageSize; //获得总共多少页
	 int pageMode = recordCount % pageSize;	//获得最后一页  
	 if (pageMode != 0 ) {
		 size ++;
		 return  size;
	} else {
		return size;
	}
	}
	public PageUtil() {
		super();
	}
	public PageUtil(int pageSize, int recordCount, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.currentPage = currentPage;
	}

	//得到当前页数
	public int getCurrentPage() {
		return currentPage;
	}

	//得到索引
	public int getIndex(){
		return currentPage * pageSize;
	}
	 // 设置当前页
	 public void setCurrentPage(int currentPage) {
	  int validPage = currentPage <= 0 ? 1 : currentPage;
	  validPage = validPage > getPageCount() ? getPageCount() : validPage;
	  this.currentPage = validPage;
	 }
	 // 得到每页显示的条数
	 public int getPageSize() {
	  return pageSize;
	 }
	 // 设置每页显示的条数
	 public void setPageSize(int pageSize) {
	  this.pageSize = pageSize;
	 }
	 // 得到总共的条数
	 public int getRecordCount() {
	  return recordCount;
	 }
	 // 设置总共的条数
	 public void setRecordCount(int recordCount) {
	  this.recordCount = recordCount;
	 }
	}	
