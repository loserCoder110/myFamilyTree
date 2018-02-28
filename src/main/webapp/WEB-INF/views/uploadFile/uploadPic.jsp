<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>图片的预览上传</title>
</head>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<body>
<img id="showPreview" src=""/>
<form action="/upload/pictures" method="post" enctype="multipart/form-data">
  请选择图片：<input id="uploadPic" name="myfile" type="file"/><br>
  <input type="submit" value="提交"/>
</form>

</body>

<script type="text/javascript">

$("#uploadPic").change(function(){
	
	var objUrl = window.webkitURL.createObjectURL(this.files[0]);
	console.log("objUrl="+objUrl);
	
	$("#showPreview").attr("src",objUrl);
	
});

</script>

</html>