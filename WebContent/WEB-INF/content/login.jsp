<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%  String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

<title>登录表单</title>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.6.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Meta-Tags -->

<!-- Style -->
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css"
	media="all">

    



<style>

	#registerbtn,#submit { width: 60%;
    padding: 10px 0;
    font-size: 16px;
    font-weight: 100;
    background-color: transparent;
    color: #CCC;
    border: 1px solid rgba(238, 238, 238, 0.41);
    border-width: thin;
    cursor: pointer;
    outline: none;
    transition: 0.5s all;
    -webkit-transition: 0.5s all;
    -moz-transition: 0.5s all;
    -o-transition: 0.5s all;
    -ms-transition: 0.5s all;
    text-decoration: none;
}
</style>
</head>
<!-- //Head -->

<!-- Body -->
<body>

	<h1>登录表单</h1>

	<div  class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<form >
				<input  type="text" Name="loginname" id="loginname" placeholder="用户名"
					 />
			
				
				 <input  type="password" Name="password"
					id="password" placeholder="密码"  />
		
			
				<div class="send-button w3layouts agileits">
					<input id="submit" type="submit" name="action" value="登 录" formaction="login">
					<input name="action" type="button" id="submit"  value="注 册"  onclick="location.href='registration'" />
				</div>
				<font color="red">${requestScope.message }</font>
			</form>

			<div class="clear"></div>
		</div>
		
		

		<div class="clear"></div>

	</div>



</body>
<!-- //Body -->

</html>