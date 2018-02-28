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
		//��ȡ�ϴ����ļ���
		InputStream fileSource = request.getInputStream();
		
		//������ı��ļ��������ǽ���һ��
		String fileName = "D:/adc.txt";
		
		File newFile = new File(fileName);
		
		FileOutputStream outputStream = new FileOutputStream(newFile);
		
		//����������ȡ�ֽڱ��浽�������
		byte[] bs = new byte[1024];
		
		int n;
		
		while((n=fileSource.read(bs))!=-1){
			outputStream.write(bs, 0, n);
			
		}
		
		outputStream.close();
		
		
		
		System.out.println("ͼƬ�ύ�С�������");
		return null;
		
	}
	

}
