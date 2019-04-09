package com.lero.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lero.mapper.UserMapper;
import com.lero.model.User;
import com.lero.service.UserService;
@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	boolean flag=false;
	
	@RequestMapping(value="/login")
	 public String login(
			 String loginname,String password,
			 Model model,
			 HttpSession session
			 ){
		
		User user = userService.login(loginname, password);
		System.out.println("1");
		System.out.println(loginname+" "+password);
		if(loginname==""&&password=="")
		{
			model.addAttribute("message", "用户名和密码不能为空");
			System.out.println("3");
			return "login";
		}
		else if(loginname==""&&password!="")
		{
			model.addAttribute("message", "用户名不能为空");
			System.out.println("3");
			return "login";
		}
		else if(loginname!=""&&password=="")
		{
			model.addAttribute("message", "密码不能为空");
			System.out.println("3");
			return "login";
		}
		else if(user != null){
			
			session.setAttribute("user", user);
			flag=false;
			
			System.out.println("2");
		
			return "main";
			
		}else if(user==null&&flag){
			
			model.addAttribute("message", "用户名或密码错误!");
			System.out.println("3");
			return "login";
			
			
		}
		else
		{
			model.addAttribute("message", "");
			System.out.println("3");
			flag=true;
			return "login";
		}
		
	}
	
	@RequestMapping(value="/back")
	 public String back(
			 String loginname,String password,
			 Model model,
			 HttpSession session){
		
		System.out.println("1");
		System.out.println(loginname+" "+password);
			return "login";
			
		
		
	}
	
	

	@RequestMapping(value="/registration")
	 public String registration(
			 User user,
			 Model model,
			 HttpSession session){
		return "registration";
			
			
		
		
	}
		
	@RequestMapping(value="/registrationok")
	 public String registrationok(
			 User user,
			 Model model,
			 HttpSession session){
		User user2 = userService.boolZ(user.getLoginname());
		
		if(user.getLoginname()==""||user.getMailbox()==""||user.getName()
				==""||user.getPassword()==""||user.getPhonenumber()=="")
		{
			model.addAttribute("result",1);
			return "registration";
		}
		else if(user2!=null)
		{
			model.addAttribute("result",2);
			model.addAttribute("message", "用户名已存在");
			return "registration";
		}
		else
		{model.addAttribute("result",0);
		model.addAttribute("message", "注册成功");
		System.out.println(user.getPassword());
		userService.saveuser(user);
		return "login";
			
		}
			
			
		
		
	}
	}

