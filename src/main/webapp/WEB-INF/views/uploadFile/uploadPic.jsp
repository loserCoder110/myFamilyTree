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

<h1>使用smartupload上传</h1>
<form action="/upload/smartUploadFile" method="post" enctype="multipart/form-data">
   上传文件1：<input type="file" name="myfile1"><br>
   <br>
   上传文件2：<input type="file" name="myfile2"><br>
   <br>
   上传文件3：<input type="file" name="myfile3">
<input type="submit" value="SUBMIT">

</form>
${result} 

<h1>使用fileupload上传文件</h1>
<form action="/upload/fileUpload" method="post" enctype="multipart/form-data">
上传文件1：<input type="file" name="file1"><br>
<input type="submit" value="提交">
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