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
		System.out.println("�����ϴ�");
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
		
	}
	
	//ʹ��smartupload���ļ����ϴ�
	@RequestMapping("/smartUploadFile")
	public void smartUploadFile(ServletConfig config,HttpServletRequest request,HttpServletResponse response) throws ServletException {
		
		//�����ϴ��ļ��ı���·��
		String saveFilePath = "D:/smartupload";
		File file = new File(saveFilePath); 
		if(!file.exists()){
			file.mkdirs();  	
		}
		
		SmartUpload smartUpload = new SmartUpload();
		//��ʼ������
		smartUpload.initialize(config, request, response);
		
		//�����ϴ��ļ���С
		smartUpload.setMaxFileSize(1024*1024*10);
		
		//���������ļ��Ĵ�С
		smartUpload.setTotalMaxFileSize(1024*1024*100);
		
		//���������ϴ����ļ�����
		smartUpload.setAllowedFilesList("txt,jpg,png");
		String result = "";
		
		//���ò������ϴ����ļ�����
		try {
			smartUpload.setDeniedFilesList("rar,jar,jsp");
			
			//�ϴ��ļ�
			smartUpload.upload();
			
			int count = smartUpload.save(saveFilePath);
			System.out.println("�ϴ��ɹ�"+count+"���ļ�");
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
