package com.ssm.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.EasyUIDateGrid;
import com.ssm.pojo.Film;
import com.ssm.service.FilmService;

@Controller
public class FilmControll {

	@Resource
	private FilmService filmService;
	
	@RequestMapping("/showlist")
	public String list(Map<String, Object> map, HttpServletRequest request) {
		return "showlist";
	}
	
	//查询用的数据
	@RequestMapping("/showListById")
	public @ResponseBody EasyUIDateGrid selectByIdList(HttpServletRequest request,Integer page,Integer rows){
		EasyUIDateGrid reDateGrid = new EasyUIDateGrid();
		String  filmId  = request.getParameter("info");
		System.out.println("jsp传过来的值："+filmId);
		reDateGrid = filmService.selectById(Integer.parseInt(filmId),page,rows);
		return reDateGrid;
	}
	
	//接受页面传递过来的参数page，rows这两个参数，然后返回json格式，给easyui用的
	@RequestMapping("/getEasyUIDateGrid")
	public @ResponseBody EasyUIDateGrid  getItemList(Integer page,Integer rows){
		EasyUIDateGrid reDateGrid = new EasyUIDateGrid();
		reDateGrid =filmService.getItemList(page , rows);
		return reDateGrid;
	}
	
	//删除数据用的
	@RequestMapping("/delecte")
	public  void  deleteList(HttpServletRequest requests,HttpServletResponse response){ 
		System.out.println("到了	deleteList");
		List<Object> list  = new ArrayList<Object>();
		String[] id =requests.getParameterValues("idStr");//得到
		System.out.println("------------------------------------");
		for (int i = 0; i < id.length; i++) {
			System.out.println(id[i]);
			list.add(id[i]);
		}
		PrintWriter print = null;
		int indexId = 0;
		//捕获异常信息
		 try {
			 indexId = filmService.delete(list);
			 print = response.getWriter();
			 print.print(indexId);
			 print.flush();
			 print.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			indexId = -1;
		}
	}
	//增加数据用的
	@RequestMapping("/addList")
	public  String addList(HttpServletRequest  request,Film film){
		System.out.println("到了add Control");
		String infomation = request.getParameter("infomation");
		System.out.println(infomation);
		String[] split =  infomation.split(",");
		int id = Integer.parseInt(split[2]);
		System.out.println(id);
		film.setTitle(split[0]);
		film.setLanguageId(id);
    	film.setDescription(split[1]);
		int size = filmService.insert(film);
		System.out.println("the size is" + size);
		return "redirect:/showlist";
	}
	//修改用户用户
	@RequestMapping("/alterList")
	public  String alterList(HttpServletRequest  request,Film film){
		System.out.println("到了alterList");
		String infomation = request.getParameter("infomation");
		System.out.println(infomation);
		String[] split =  infomation.split(",");
		int id = Integer.parseInt(split[3]);
		System.out.println(id);
		film.setFilm_id(split[0]);
		film.setTitle(split[1]);
		film.setLanguageId(id);
    	film.setDescription(split[2]);
    	int index = filmService.alter(film);
    	System.out.println("---------------------------------");
    	System.out.println(index);
    	System.out.println("---------------------------------");
		return "redirect:/showlist";
	}
	
	
}
