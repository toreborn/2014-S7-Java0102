<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<style>
			body{
				margin:0;
			}
			.head{
				height:50px;
				width:100%;
				background-color:#ADFEDC;
			}
			.logo{
				color:red;
				font-style:Italic;
				font-weight:bold;
				font-size:25px;
				line-height:50px;
				margin:0 20px 0 20px;
			}
			.userinfo{
				float:right;
				line-height:50px;
				margin-right:30px;
			}
			#shadowDiv{
				position:absolute;
				top:0;
				left:0;
				width:100%;
				height:100%;
				background-color:#977C00;
				opacity:0.4;
				display:none;
				z-index:5;
			}
			#login{
				position:absolute;
				width:400px;
				height:200px;
				background-color:white;
				top:50%;
				left:50%;
				margin:-100px 0 0 -200px;
				z-index:6;
				display:none;
				padding:10px;
			}
			.cancelSpan{
				display:block;
				width:20px;
				height:20px;
				border:1px solid black;
				border-radius:10px;
				text-align:center;
				line-height:20px;
				float:right;
			}
			.cancelSpan:hover{
				background-color:#0080FF;
				color:red;
				cursor:pointer;
			}
		</style>
	</head>
<body>
	<div class="head">
		<span class="logo">Video</span>
		<span>
			<input type="text" name="content" 
			style="height:25px;width:30%;"/>
		</span>
		<span>
			<input type="submit" style="height:30px;"/>
		</span>
		<span class="userinfo">
			<a href="javascript:login()">登录</a>|<a href="javascript:register()">注册</a>
		</span>
	</div>
	
	<div id="shadowDiv">
	</div>
	<div id="login">
		<span class="cancelSpan">x</span>
	</div>
</body>
<script>
	function login(){
		document.getElementById("shadowDiv").style.display="block";
		document.getElementById("login").style.display="block";
	}
</script>


</html>