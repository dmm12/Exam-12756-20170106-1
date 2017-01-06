package com.ssm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ssm.pojo.EasyUIDateGrid;
import com.ssm.pojo.Film;
import com.ssm.pojo.User;

public interface FilmService {
	//根据id来查询数据
	public EasyUIDateGrid selectById(int id,int page,int rows);
	
	public User selectUsername(String name);
	
	//easyui分页，将取得的数据保存着在EasyUIDateGrid中，通过他来取
	EasyUIDateGrid getItemList(int page, int rows);
	
	//批量查询
	public int delete(List<Object> list);
	
	//插入
	public int insert(Film film);
	
	//修改
	public int alter(Film film);
}
