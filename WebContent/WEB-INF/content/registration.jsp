<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%  String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

<title>注册表单</title>

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
<script>

<script>
//对应后台返回的提示
if ('${result}' != '') {
    if ('${result}' == 0) {
        alert('注册成功，将跳转到登录页面！')
        location.href = '/zyf/dl'
    }
    if ('${result}' == 1) {
        alert('内容不能为空，注册失败！')
    }
    if ('${result}' == 2) {
        alert('该账号已有人注册！')
    }

}


</script>
 	


</script>
<script>
	

</script>
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

	
		
		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<form >
				<input style="float: left;width:150px"  type="text" Name="loginname" placeholder="用户名" required="required" id="loginname"/>
			
				<div style="float: left;width:150px"  id="nametip"></div>
				
				<input style="float: left;width:150px" type="password" Name="password" placeholder="密码" required="required" id="password"/>
				<div  style="float: left;width:150px" id="emailtip"></div>
				<input style="float: left;width:150px" type="text" Name="name" placeholder="昵称"
					required="required" id="name"/> 	
				<div  style="float: left;width:150px" id="pwdtip"></div>
	
				<input style="float: left;width:150px" type="text" Name="phonenumber"
					placeholder="手机号码" required="required" id="phonenumber"/>
					
			<div  style="float: left;width:150px" id="teltip"></div>
			
			<input style="float: left;width:150px" type="text" Name="mailbox"
					placeholder="邮箱" required="required" id="mailbox"/>
					
			<div  style="float: left;width:150px" id="teltip"></div>
			
				<div class="send-button w3layouts agileits">

					<input id="submit" type="submit" name="action" value="注 册" formaction="registrationok">

				</div>
				<font color="red">${requestScope.message }</font>
			</form>

			<div class="clear"></div>
		</div>

		<div class="clear"></div>

	



</body>
<!-- //Body -->

</html>