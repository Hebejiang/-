<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>失物招领系统</title>

<link href="<%=basePath%>templatemo_style.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet" href="<%=basePath%>css/orman.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="<%=basePath%>css/nivo-slider.css"
	type="text/css" media="screen" />

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/ddsmoothmenu.css" />

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
			<div class="nav">你好,${user.loginname}</div>
		</c:when>
		<c:otherwise>
		
			<a class="nav" style="text-decoration: underline;" href="login">考虑一下登录吧!</a>
		
		</c:otherwise>
	</c:choose>
	<div id="templatemo_wrapper_h">
		<div id="templatemo_header_wh">
			<div id="templatemo_header" class="header_home">
				<div id="site_title">
					<a href="" title=""></a>
				</div>
				<div id="templatemo_menu" class="ddsmoothmenu">
					<ul>

						<li><a href="main" class="selected">主页</a></li>
						<li><a href="lost">寻物启事</a></li>
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
							<input type="text"  required="required" name="keyword" id="keyword"
								title="keyword" onfocus="clearText(this)"
								onblur="clearText(this)"  class="txt_field"  /> <input
								type="submit" name="" value="" alt="Search"
								id="searchbutton" title="Search" class="sub_btn" />
						</form>
					</div>
					<br style="clear: left" />
				</div>
				<!-- end of templatemo_menu -->

				
				<script type="text/javascript"
					src="<%=basePath%>js/jquery-1.6.1.min.js"></script>
				<script type="text/javascript"
					src="<%=basePath%>js/jquery.nivo.slider.pack.js"></script>
				<script type="text/javascript">
        $(window).load(function() {
            $('#slider').nivoSlider({
				controlNav:false
			});
        });
        </script>
			</div>
			<!-- END of header -->
		</div>
		<!-- END of header wrapper -->
		
				
				<div class="text" style=" text-align:center;">
					<h2>欢迎使用本系统</h2>
					<p>制作人：软件162 宋延杰</p>

					


	
			
			
					
				

			</div>
			<!-- END of main -->
		</div>
		<!-- END of main wrapper -->


	

</body>
<script type="text/javascript" src="<%=basePath%>js/logging.js"></script>
</html>