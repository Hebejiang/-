package com.lero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**   
 * @Description: 
 * <br>网站�?<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文�?	36750064@qq.com   
 * @version V1.0   
 */

/**
 * 动�?�页面跳转控制器
 * */
@Controller
public class FormController{

	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName){
		// 动�?�跳转页�?
		return formName;
	}

}

