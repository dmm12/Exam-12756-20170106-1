package com.ssm.pojo;

import java.util.List;

import org.codehaus.plexus.component.annotations.Component;

/**
 * 返回一个EasyUIDateGrid支持的数据格式
 * easyUi能够接受的格式是{total:2 ,row:{"id":"1","name":"张三"，"age":"20"}}这样子的json格式
 * @author mm
 */
public class EasyUIDateGrid {
	private long total;
	private List<?> rows; //？可以加任意数据类型进去
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
