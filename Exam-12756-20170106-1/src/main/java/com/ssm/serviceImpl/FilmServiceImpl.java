package com.ssm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.FilmDao;
import com.ssm.pojo.EasyUIDateGrid;
import com.ssm.pojo.Film;
import com.ssm.pojo.User;
import com.ssm.service.FilmService;

@Service("filmService")
public class FilmServiceImpl implements FilmService{
	
	@Resource
	public   FilmDao	filmDao ;
	
//	@Resource 
//	public  EasyUIDateGrid easyDate;

	@Override
	public User selectUsername(String name) {
		// TODO Auto-generated method stub
		User user = filmDao.selectUsername(name);
		if(user == null){
			System.out.println("对不起，没有该用户！");
			return null;
		}
		System.out.println("有的");
		return user;
	}

	//easyUi通过service层
	@Override
	public EasyUIDateGrid getItemList(int page, int rows) {
		//开始进行分页
		PageHelper.startPage(page, rows);
		List<Film> list = filmDao.selectFilmList();
		//返回对象
		EasyUIDateGrid  easyDate = new EasyUIDateGrid();
		easyDate.setRows(list);
		//取记录的总条数，pageinfo包括记录的条数，记录的大小,下一页，上一页等等
		PageInfo<Film> pageInfo = new PageInfo<Film>(list);
		easyDate.setTotal(pageInfo.getTotal());
		//返回easyui的对象
		return easyDate;
	}

	@Override
	public int delete(List<Object> list) {
		int film_index = filmDao.delete(list);
		if(film_index < 1){
			System.out.println("无数据");
			return 0;
		}
		return film_index;
	}

	@Override
	public int insert(Film film) {
		int target = filmDao.insertList(film);
		if(target < 1){
			System.out.println("插入失败");
		}
		return target;
	}

	@Override
	public int alter(Film film) {
		// TODO Auto-generated method stub
		System.out.println("ssss"+film.toString());
		int target = filmDao.updateSelective(film);
		if(target < 1){
			System.out.println("修改失败");
		}
		return target;
	}

	@Override
	public EasyUIDateGrid selectById(int id, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<Film> selectByIdList = filmDao.selectById(id);
		EasyUIDateGrid  easyDate = new EasyUIDateGrid();
		easyDate.setRows(selectByIdList);
		//取记录的总条数，pageinfo包括记录的条数，记录的大小,下一页，上一页等等
		PageInfo<Film> pageInfo = new PageInfo<Film>(selectByIdList);
		easyDate.setTotal(pageInfo.getTotal());
		//返回easyui的对象
		return easyDate;
	}


}
