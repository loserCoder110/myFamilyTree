package com.ldw.familyTree.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("uploadController")
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping("/pictures")
	public String uploadPic(HttpServletRequest request) throws IOException{
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
		return null;
		
	}
	

}
