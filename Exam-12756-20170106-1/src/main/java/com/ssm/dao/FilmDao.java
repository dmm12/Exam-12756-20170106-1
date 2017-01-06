package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.pojo.Film;
import com.ssm.pojo.User;

public interface FilmDao {
	
	public List<Film> selectFileList(@Param("id")Integer id);
	
	//统计film_id
	public int countNum( );
	
	//根据id查询数据
	public List<Film> selectById(@Param("id") Integer id);
	
	//登录
	public User selectUsername(String name);
	//注意传入的参数和数据库xml的参数要一样
	
	//查询所有的数据，没有limit的方法
	public List<Film> selectFilmList( );
	
	//批量删除
	public int delete(List<Object> list);
	
	//插入的方法
	public int insertList(Film film);
	
	//修改
	public int updateSelective(Film film);
}