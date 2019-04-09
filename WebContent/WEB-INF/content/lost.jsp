<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>失物招领系统</title>
<meta name="keywords"
	content="free template, floral shop, ecommerce, online shopping, store" />
<meta name="description"
	content="Floral Shop, Products, free website template for ecommerce shopping websites." />
<link href="<%=basePath%>templatemo_style.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet" href="<%=basePath%>css/orman.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="<%=basePath%>css/nivo-slider.css"
	type="text/css" media="screen" />

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/ddsmoothmenu.css" />
<script type='text/javascript' src='<%=basePath%>js/logging.js'></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}

</script>


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
						<li><a href="#" class="selected">寻物启事</a></li>
						<li><a href="find">失物招领</a></li>
						<c:if test="${not empty user.loginname}">
						<li><a href="mylost">我丢失的物品</a></li>
						<li><a href="myfind">我捡到的物品</a></li>
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
								<li><a href="lost">全部</a></li>
														
								<li><a href="lostmune?type=1">一卡通</a></li>
								
								<li><a href="lostmune?type=2">身份证</a></li>
								
								<li><a href="lostmune?type=3">银行卡</a></li>
								
								<li><a href="lostmune?type=4">水卡</a></li>
								
								<li><a href="lostmune?type=5">手机</a></li>
								
								<li><a href="lostmune?type=6">钱包</a></li>
								
								<li><a href="lostmune?type=7">书包</a></li>
								
								<li><a href="lostmune?type=8">其他</a></li>
							</ul>
						</div>
					</div>
					
				</div>

				<div id="content" class="right">
					
					<c:forEach items="${llt}" var="lost">
				
						<div class="product_box">
							<a
								href="lostdetail?lostid=${lost.getLostid() }"><img
								src="<%=basePath%><c:out value="${lost.getLostphoto()}" />"
								alt="floral set 1" height="165" width="165"/></a></a>
							<h3>
								<c:out value="${lost.getLosttitle()}" />
							</h3>
							<p class="product_price" >
								<c:out value="${lost.getType()}" />
							</p>
							<p class="add_to_cart">
								<a
									href="lostdetail?lostid=${lost.getLostid()}">详情</a>
																			
							</p>
						</div>
					</c:forEach>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="blank_box">
	  
		<a class="button left" href="lost?pageNow=1">首页</a>
		<c:choose>
			
			<c:when test="${page.pageNow - 1 > 0}">
				<a class="button left" href="lost?pageNow=${page.pageNow - 1}">上一页</a>
			</c:when>
			<c:when test="${page.pageNow - 1 <= 0}">
				<a class="button left" href="lost?pageNow=1">上一页</a>
			</c:when>
		</c:choose>
		
		
		<c:choose>
			<c:when test="${page.totalPageCount==0}">
				<a class="button right" href="lost?pageNow=${page.pageNow}">尾页</a>
			</c:when>
			<c:otherwise>
				<a class="button right" href="lost?pageNow=${page.totalPageCount}">尾页</a>
			</c:otherwise>
		</c:choose>
			<c:choose>
			<c:when test="${page.totalPageCount==0}">
				<a class="button right" href="lost?pageNow=${page.pageNow}">下一页</a>
			</c:when>
			<c:when test="${page.pageNow + 1 < page.totalPageCount}">
				<a class="button right" href="lost?pageNow=${page.pageNow + 1}">下一页</a>
			</c:when>
			<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
				<a class="button right" href="lost?pageNow=${page.totalPageCount}">下一页</a>
			</c:when>
		</c:choose>
	
		<div style="text-align: center; color: red;font-weight: bold;">
			<font size="2">第${page.pageNow} 页</font>
			<font size="2">共 ${page.totalPageCount} 页</font>
		</div>
	</div>	
					
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- END of main -->
		</div>
		<!-- END of main wrapper -->


	</div>

</body>

</html>