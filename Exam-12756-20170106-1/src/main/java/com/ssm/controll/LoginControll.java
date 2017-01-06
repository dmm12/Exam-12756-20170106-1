package com.ssm.controll;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;
import com.ssm.service.FilmService;

@Controller
public class LoginControll {
	
	@Resource
	FilmService filmService;
	
	@RequestMapping("/showJsp")
	public String showjsp(){
		return "login";
	}
	
	@RequestMapping("/Login")
	public	String judgeLogin(HttpServletRequest request,Model model,Map<String, Object> map) throws ServletException, IOException{
		String userName = request.getParameter("username");
		System.out.println(userName);
		User user = filmService.selectUsername(userName);
		if(user ==null){
			model.addAttribute("error", "输入信息不正确，请重新输入！");
			return "redirect:/login.html";
		}else{
			//这里已经登录成功了
//			HttpSession session = request.getSession();
//			session.setAttribute("username",userName);
			return "redirect:/showlist"; //FilmControll
		}
	}
}
