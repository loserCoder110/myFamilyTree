<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>user login</title>
<link rel="stylesheet" type="text/css" href="../static/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="../static/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="../static/css/component.css" />
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎你</h3>
						<form action="/user/login" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							     <input id="submit1" type=submit value="submit">
							<div class="mb2"><a class="act-but submit" href="javascript:submitForm()" style="color: #FFFFFF">登录</a></div>
						</form>
						<div>
						 <span> 尚未注册账号？请<a href="/user/register">注册</a> </span>
						 <span> 练习文件的上传，请点击<a href="/user/toUploadPic">图片上传</a></span>
						</div>
						
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="../static/js/TweenLite.min.js"></script>
		<script src="../static/js/EasePack.min.js"></script>
		<script src="../static/js/rAF.js"></script>
		<script src="../static/js/demo-1.js"></script>
		<div style="text-align:center;">
</div>
	</body>
	<script type="text/javascript">
	
/* 	function submitForm(){
		$("#submit1").click();
	} */

	
	</script>
	
	
	
</html>