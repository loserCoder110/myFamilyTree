package com.ldw.familyTree.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.jspsmart.upload.SmartUpload;
import com.sun.mail.imap.protocol.Item;

@Controller("uploadController")
@RequestMapping("/upload")
public class UploadController  implements ServletConfigAware,ServletContextAware{
	
	/**
	 * ʹ��smartuploadʱ��Ҫ�õ�servletConfig������ʹ��servletʱ�ǳ����׻�ȡ��
	 * ����Controller��Ҫ������ȡ
	 * */
	private ServletContext servletContext;
	
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
		
	}
    
	private ServletConfig servletConfig;
	public void setServletConfig(ServletConfig arg0) {
		this.servletConfig = arg0;
		
	}

	//controller��ʼ
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
	public void smartUploadFile(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		
		//�����ϴ��ļ��ı���·��
		String saveFilePath = "D:/smartupload";
		File file = new File(saveFilePath); 
		if(!file.exists()){
			file.mkdirs();  	
		}
		
		SmartUpload smartUpload = new SmartUpload();
		//��ʼ������
		smartUpload.initialize(servletConfig, request, response);
		
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
			if(e.getMessage().indexOf("1015")!=-1){
				result = "�ϴ�ʧ�ܣ��ϴ��ļ����Ͳ���ȷ��";
			}else if (e.getMessage().indexOf("1010")!=-1) {
				result = "�ϴ�ʧ�ܣ��ϴ��ļ����Ͳ���ȷ��";
			}else if (e.getMessage().indexOf("1105")!=-1) {
				result = "�ϴ�ʧ�ܣ��ϴ��ļ���С������������ֵ��";
			}else if (e.getMessage().indexOf("1110")!=-1) {
				result = "�ϴ�ʧ�ܣ��ϴ��ļ��ܴ�С������������ֵ��";
			}
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		
	}

	//ʹ��fileupload�ϴ��ļ�
	@RequestMapping("/fileUpload")
	public String fileUpload(HttpServletRequest request,HttpServletResponse response){
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(3*1024*1024);
		
		upload.setSizeMax(5*1024*1024);
		
		if(ServletFileUpload.isMultipartContent(request)){
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem fileItem : list) {
					String name = fileItem.getName();
					System.out.println("�ϴ��ļ���:"+name);
					String id = UUID.randomUUID().toString();
					
					name = id+name;
					System.out.println("������ɵ��ļ�����"+name);
					
					String mockServer = "D:/fileUpload";
					File file = new File(mockServer); 
					if(!file.exists()){
						file.mkdirs();  	
					}
					File file2 = new File(mockServer+File.separator+name);
					fileItem.write(file2);
					fileItem.delete();
				}
			} catch (FileUploadException e) {
				
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return null;
	}
	

}
