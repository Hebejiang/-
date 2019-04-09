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

import com.lero.model.FindInformation;
import com.lero.model.LostInformation;
import com.lero.model.Page;
import com.lero.model.User;
import com.lero.service.FindService;
import com.lero.service.LostService;
@Controller
public class FindController {
	@Autowired
	@Qualifier("findService")
	private FindService findService;
	
	@RequestMapping(value="/find")
	 public String findlist(
			 Model model,HttpServletRequest request
			 ){
		String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=(int)findService.selectCount1();
        System.out.println(totalCount);
        Page page=null;
        List<FindInformation> flt=new ArrayList<FindInformation>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            flt=this.findService.getAll1(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            flt=this.findService.getAll1(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("flt", flt);
        model.addAttribute("page", page);
		
			return "find";
			
}
	
	@RequestMapping(value="/findmune")
	 public String findnume(
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
       int totalCount=(int)findService.selectCount1();
       System.out.println(totalCount);
       Page page=null;
       List<FindInformation> flt=new ArrayList<FindInformation>();
       if (pageNow!=null) {
           page=new Page(Integer.parseInt(pageNow), totalCount);
           flt=this.findService.getmune1(type, page.getStartPos(), page.getPageSize());
       }else {
           page=new Page(1, totalCount);
           flt=this.findService.getmune1(type, page.getStartPos(), page.getPageSize());
       }
       model.addAttribute("flt", flt);
       model.addAttribute("page", page);
		
			return "find";
			
}
	
	@RequestMapping(value="/myfind")
	 public String myfindlist(
			 Model model,HttpSession session,HttpServletRequest request
			 ){
		User user=new User();
		user=(User) session.getAttribute("user");
		String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=(int)findService.selectMyCount1(user.getLoginname());
        Page page=null;
        List<FindInformation> myflt=new ArrayList<FindInformation>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            myflt=this.findService.getMyAll1(user.getLoginname(), page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            myflt=this.findService.getMyAll1(user.getLoginname(), page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("myflt", myflt);
        model.addAttribute("page", page);
		
		
		
			return "myfind";
			
}
	
	@RequestMapping(value="/myfindmune")
	 public String myfindmune(
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
       int totalCount=(int)findService.selectMyCount1(user.getLoginname());
       Page page=null;
       List<FindInformation> myflt=new ArrayList<FindInformation>();
       if (pageNow!=null) {
           page=new Page(Integer.parseInt(pageNow), totalCount);
           myflt=this.findService.getmymune1(type, user.getLoginname(), page.getStartPos(),page.getPageSize());
       }else {
           page=new Page(1, totalCount);
           myflt=this.findService.getmymune1(type, user.getLoginname(), page.getStartPos(),page.getPageSize());
       }
       model.addAttribute("myflt", myflt);
       model.addAttribute("page", page);
		
		
		
			return "myfind";
			
}
	
	@RequestMapping(value="/finddetail")
	 public String lostdetail(
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ){
		int findid = Integer.parseInt(request.getParameter("findid"));
		List<FindInformation> flt = findService.getAlllist1();
		FindInformation find=flt.get(findid);
		User fuser=findService.selectUser1(find.getFindloginname());
		if(fuser!=null)
		{
			System.out.println(find.getType());
			System.out.println(fuser.getMailbox());
		}
		else
		{
			System.out.println("error");
		}
		System.out.println(find.getType());
		model.addAttribute("find", find);
		model.addAttribute("fuser", fuser);
		
			return "finddetail";
			
}
	
	@RequestMapping(value="/myfinddetail")
	 public String myfinddetail(
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ){
		int findid = Integer.parseInt(request.getParameter("findid"));
		User user=new User();
		user=(User) session.getAttribute("user");
		List<FindInformation> myflt = findService.getMyAllFind1(user.getLoginname());
		FindInformation find=myflt.get(findid);
		System.out.println(findid);
		System.out.println(find.getFindloginname());
		User fuser=findService.selectUser1(find.getFindloginname());
		if(fuser!=null)
		{
			System.out.println(find.getType());
			System.out.println(fuser.getMailbox());
		}
		else
		{
			System.out.println("error");
		}
		System.out.println(find.getType());
		model.addAttribute("find", find);
		model.addAttribute("fuser", fuser);
		
			return "myfinddetail";
			
}
	
	@RequestMapping(value="/addfind")
	 public String addfind(
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ){
		
		
			return "addfind";
			
}
	
	@RequestMapping(value="/addfinddetail")
	 public String addfinddetail (
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ,@RequestParam("file") MultipartFile file)throws Exception{
		FindInformation fif=new FindInformation();
		fif.setType(request.getParameter("type"));
		fif.setFinddetail(request.getParameter("finddetail"));
		fif.setFindtitle(request.getParameter("findtitle"));
		
		System.out.println(fif.getType());
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
		fif.setFindphoto(sqlPath);
		int id=findService.getId1()+1;
		fif.setFindid(id);
		User user=new User();
		user=(User) session.getAttribute("user");
		fif.setFindloginname(user.getLoginname());
		findService.savefind(fif);
		
			return "main";
		
			
}
	
	@RequestMapping(value="/detelemyfind")
	 public String detelemyfind(
			 Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response
			 ){
		int findid = Integer.parseInt(request.getParameter("findid"));
		
		findService.removefind1(findid);
		
		
			return "main";
			
}
}
