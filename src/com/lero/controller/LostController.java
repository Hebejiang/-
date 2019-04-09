package com.lero.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lero.model.LostInformation;
import com.lero.model.Page;
import com.lero.model.User;
import com.lero.service.LostService;



@Controller
public class LostController {
	@Autowired
	@Qualifier("lostService")
	private LostService lostService;
	
	@RequestMapping(value="/lost")
	 public String lostlist(
			 Model model,HttpServletRequest request
			 ){
		
		 String pageNow=request.getParameter("pageNow");
         //获取总页数
         int totalCount=(int)lostService.selectCount();
         Page page=null;
         List<LostInformation> llt=new ArrayList<LostInformation>();
         if (pageNow!=null) {
             page=new Page(Integer.parseInt(pageNow), totalCount);
             llt=this.lostService.getAll(page.getStartPos(),page.getPageSize());
         }else {
             page=new Page(1, totalCount);
             llt=this.lostService.getAll(page.getStartPos(),page.getPageSize());
         }
         model.addAttribute("llt", llt);
         model.addAttribute("page", page);

		
			return "lost";
			
}
	
	@RequestMapping(value="/lostmune")
	 public String lostmune(
			 Model model,HttpServletRequest request
			 ){
		int typ = Integer.parseInt(request.getParameter("type"));
		String type=null;
		switch(typ)
		{
		case 1:{type="一卡通";break;}
		case 2:{type="身份证";break;}
		case 3:{type="银行卡";break;}
		case 4:{type="水卡";break;}
		case 5:{type="手机";break;}
		case 6:{type="钱包";break;}
		case 7:{type="书包";break;}
		case 8:{type="其他";break;}
		}
		 String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=(int)lostService.selectCount();
        Page page=null;
        List<LostInformation> llt=new ArrayList<LostInformation>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            llt=this.lostService.getmune(type,page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            llt=this.lostService.getmune(type,page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("llt", llt);
        model.addAttribute("page", page);

		
			return "lost";
			
}
	
	@RequestMapping(value="/mylost")
	 public String mylostlist(
			 Model model,HttpSession session,HttpServletRequest request
			 ){
		
		User user=new User();
		user=(User) session.getAttribute("user");
		String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=(int)lostService.selectMyCount(user.getLoginname());
        Page page=null;
        List<LostInformation> myllt=new ArrayList<LostInformation>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            myllt=this.lostService.getMyAll(user.getLoginname(), page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            myllt=this.lostService.getMyAll(user.getLoginname(), page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("myllt", myllt);
        model.addAttribute("page", page);
			return "mylost";
			
}
	@RequestMapping(value="/mylostmune")
	 public String mylostmune(
			 Model model,HttpSession session,HttpServletRequest request
			 ){
		int typ = Integer.parseInt(request.getParameter("type"));
		String type=null;
		switch(typ)
		{
		case 1:{type="一卡通";break;}
		case 2:{type="身份证";break;}
		case 3:{type="银行卡";break;}
		case 4:{type="水卡";break;}
		case 5:{type="手机";break;}
		case 6:{type="钱包";break;}
		case 7:{type="书包";break;}
		case 8:{type="其他";break;}
		}
		User user=new User();
		user=(User) session.getAttribute("user");
		String pageNow=request.getParameter("pageNow");
       //获取总页数
       int totalCount=(int)lostService.selectMyCount(user.getLoginname());
       Page page=null;
       List<LostInformation> myllt=new ArrayList<LostInformation>();
       if (pageNow!=null) {
           page=new Page(Integer.parseInt(pageNow), totalCount);
           myllt=this.lostService.getmymune(type,user.getLoginname(), page.getStartPos(),page.getPageSize());
       }else {
           page=new Page(1, totalCount);
           myllt=this.lostService.getmymune(type,user.getLoginname(), page.getStartPos(),page.getPageSize());
       }
       model.addAttribute("myllt", myllt);
       model.addAttribute("page", page);
			return "mylost";
			
}
	
	@RequestMapping(value="/lostdetail")
	 public String lostdetail(
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ){
		int lostid = Integer.parseInt(request.getParameter("lostid"));
		List<LostInformation> llt = lostService.getAlllist();
		LostInformation lost=llt.get(lostid);
		
		User luser=lostService.selectUser(lost.getLostloginname());
		if(luser!=null)
		{
			System.out.println(lost.getType());
			System.out.println(luser.getMailbox());
		}
		else
		{
			System.out.println("error");
		}
		System.out.println(lost.getType());
		model.addAttribute("lost", lost);
		model.addAttribute("luser", luser);
		
			return "lostdetail";
			
}
	
	@RequestMapping(value="/mylostdetail")
	 public String mylostdetail(
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ){
		int lostid = Integer.parseInt(request.getParameter("lostid"));
		User user=new User();
		user=(User) session.getAttribute("user");
		List<LostInformation> myllt = lostService.getMyAllLost(user.getLoginname());
		LostInformation lost=myllt.get(lostid);
		System.out.println(lostid);
		System.out.println(lost.getLostloginname());
		User luser=lostService.selectUser(lost.getLostloginname());
		if(luser!=null)
		{
			System.out.println(lost.getType());
			System.out.println(luser.getMailbox());
		}
		else
		{
			System.out.println("error");
		}
		System.out.println(lost.getType());
		model.addAttribute("lost", lost);
		model.addAttribute("luser", luser);
		
			return "mylostdetail";
			
}
	
	@RequestMapping(value="/addlost")
	 public String addlost(
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ){
		
		
			return "addlost";
			
}
	@RequestMapping(value="/addlostdetail")
	 public String addlostdetail (
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ,@RequestParam("file") MultipartFile file)throws Exception{
		LostInformation lif=new LostInformation();
		lif.setType(request.getParameter("type"));
		lif.setLostdetail(request.getParameter("lostdetail"));
		lif.setLosttitle(request.getParameter("losttitle"));
		
		System.out.println(lif.getType());
		String sqlPath=null;//保存数据库的路径		
		String filename=null;//定义文件名		
		String contentType=file.getContentType();	//获取文件类型（后缀）
		//因为获取的后缀是XXXX/xxx形式	
		contentType=contentType.substring(contentType.indexOf("/")+1);	
		filename=file.getOriginalFilename();	
		System.out.println(filename);	
		String url =  "E:\\javawork\\lfsystem\\WebContent\\images\\";
		System.out.println(url);       
		url=url+"/";		
		file.transferTo(new File(url+filename));//保存图片
		sqlPath="images/"+filename;
		lif.setLostphoto(sqlPath);
		int id=lostService.getId()+1;
		lif.setLostid(id);
		User user=new User();
		user=(User) session.getAttribute("user");
		lif.setLostloginname(user.getLoginname());
		lostService.savelost(lif);
		
			return "main";
		
			
}
	
	@RequestMapping(value="/detelemylost")
	 public String detelemylost(
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ){
		int lostid = Integer.parseInt(request.getParameter("lostid"));
		
		
		lostService.removelost(lostid);
		
		
			return "main";
			
}
	
}
