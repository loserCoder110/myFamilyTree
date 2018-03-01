package com.ldw.familyTree.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.jspsmart.upload.SmartUpload;

@Controller("uploadController")
@RequestMapping("/upload")
public class UploadController  implements ServletConfigAware,ServletContextAware{
	
	@RequestMapping("/pictures")
	public void uploadPic(HttpServletRequest request) throws IOException{
		System.out.println("进入上传");
		//获取上传的文件流
		InputStream fileSource = request.getInputStream();
		
		//如果是文本文件，那我们接收一下
		String fileName = "D:/adc.txt";
		
		File newFile = new File(fileName);
		
		FileOutputStream outputStream = new FileOutputStream(newFile);
		
		//从输入流读取字节保存到输出流中
		byte[] bs = new byte[1024];
		
		int n;
		
		while((n=fileSource.read(bs))!=-1){
			outputStream.write(bs, 0, n);
			
		}
		
		outputStream.close();
		
		
		
		System.out.println("图片提交中。。。。");
		
	}
	
	//使用smartupload做文件的上传
	@RequestMapping("/smartUploadFile")
	public void smartUploadFile(ServletConfig config,HttpServletRequest request,HttpServletResponse response) throws ServletException {
		
		//设置上传文件的保存路径
		String saveFilePath = "D:/smartupload";
		File file = new File(saveFilePath); 
		if(!file.exists()){
			file.mkdirs();  	
		}
		
		SmartUpload smartUpload = new SmartUpload();
		//初始化对象
		smartUpload.initialize(config, request, response);
		
		//设置上传文件大小
		smartUpload.setMaxFileSize(1024*1024*10);
		
		//设置所有文件的大小
		smartUpload.setTotalMaxFileSize(1024*1024*100);
		
		//设置允许上传的文件类型
		smartUpload.setAllowedFilesList("txt,jpg,png");
		String result = "";
		
		//设置不允许上传的文件类型
		try {
			smartUpload.setDeniedFilesList("rar,jar,jsp");
			
			//上传文件
			smartUpload.upload();
			
			int count = smartUpload.save(saveFilePath);
			System.out.println("上传成功"+count+"个文件");
			result="success";			
					
		} catch (Exception e) {
			result="failed";
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		
	}

	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setServletConfig(ServletConfig arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
