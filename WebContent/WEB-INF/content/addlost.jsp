<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="multipart/form-data;         charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>失物招领系统</title>
<meta name="keywords"
	content="free template, floral shop, ecommerce, online shopping, store" />
<meta name="description"
	content="Floral Shop, Product Details, free template for ecommerce websites." />
<link href="<%=basePath%>templatemo_style.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet" href="<%=basePath%>css/orman.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="<%=basePath%>css/nivo-slider.css"
	type="text/css" media="screen" />

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/ddsmoothmenu.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1-4-2.min.js"></script>
<script type='text/javascript' src='<%=basePath%>js/logging.js'></script>
<link rel="stylesheet" href="<%=basePath%>css/slimbox2.css"
	type="text/css" media="screen" />
<script type="text/JavaScript" src="<%=basePath%>js/slimbox2.js"></script>


<style>
	.nav{
		color:#FBCF60;
		position:absolute;
		right:50px;
		top:10px;
		z-index:999;
		font-size: 20px;
		font-weight: bold;
		text-decoration: underline;
	}
</style>
</head>

<body>
	<c:choose>
		<c:when test="${not empty user.loginname}">
			<div class="nav">你好,${user.name}</div>
		</c:when>
		<c:otherwise>
			<a class="nav" style="text-decoration: underline;" href="login">考虑一下登录吧!</a>
		</c:otherwise>
	</c:choose>
	<div id="templatemo_wrapper_sp">
		<div id="templatemo_header_wsp">
			<div id="templatemo_header" class="header_subpage">
				<div id="site_title">
					<a href="" title=""></a>
				</div>
				<div id="templatemo_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="main" >主页</a></li>
						<li><a href="lost">寻物启事</a></li>
						<li><a href="find">失物招领</a></li>
						<c:if test="${not empty user.loginname}">
						<li><a href="mylost" class="selected">我丢失的物品</a></li>
						<li><a href="myfind" >我捡到的物品</a></li>
					</c:if>
						
						
							
					<c:if test="${not empty user.loginname}">
						<li><a href="back">退出登录</a></li>
				</c:if>
					</ul>
					<div id="templatemo_search">
							<form action="../jumpAction/search.do" method="post">
							<input type="text"  name="keyword" required="required" id="keyword"
								title="keyword" onfocus="clearText(this)"
								onblur="clearText(this)" class="txt_field"  /> <input
								type="submit" name="" value="" alt="Search"
								id="searchbutton" title="Search" class="sub_btn" />
						</form>
					</div>
					<br style="clear: left" />
				</div>

			</div>
			<!-- END of header -->
		</div>
		<!-- END of header wrapper -->
		<div id="templatemo_main_wrapper">
			<div id="templatemo_main">
				<div id="sidebar" class="left">
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>种类</h3>
						<div class="content">
							<ul class="sidebar_list">
								<li><a href="mylost">全部</a></li>
														
								<li><a href="mylostmune?type=1">一卡通</a></li>
								
								<li><a href="mylostmune?type=2">身份证</a></li>
								
								<li><a href="mylostmune?type=3">银行卡</a></li>
								
								<li><a href="mylostmune?type=4">水卡</a></li>
								
								<li><a href="mylostmune?type=5">手机</a></li>
								
								<li><a href="mylostmune?type=6">钱包</a></li>
								
								<li><a href="mylostmune?type=7">书包</a></li>
								
								<li><a href="mylostmune?type=8">其他</a></li>
							</ul>
						</div>
					</div>
					
				</div>
					
				
		
				<div id="content" class="right" >
				<form action="addlostdetail" enctype="multipart/form-data"method="post">
				
				
				标题<input  type="text" Name="losttitle" id="losttitle" /></br><br>
				类型<select id="type" name="type">
            		<option value="一卡通">一卡通</option>
            		<option value="身份证">身份证</option>
            		<option value="银行卡">银行卡</option>
            		<option value="水卡">水卡</option>
            		<option value="手机">手机</option>
            		<option value="钱包">钱包</option>
            		<option value="书包">书包</option>
            		<option value="其它">其它</option>
        			</select>

				<br><br>详细情况<input name="lostdetail" id="lostdetail" type="text" style="width:200px; height:200px;" /><br><br>
				上传照片（一张）<input type="file" name="file"/><br><br>
				<input type="submit" value="发 布" ></input><br><br>
					
				</form>
		</div>
		
									
					
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- END of main -->
		</div>
		<!-- END of main wrapper -->


	

</body>

</html>