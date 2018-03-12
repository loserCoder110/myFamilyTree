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
	 * 使用smartupload时需要用到servletConfig，这在使用servlet时非常容易获取，
	 * 但在Controller中要这样获取
	 * */
	private ServletContext servletContext;
	
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
		
	}
    
	private ServletConfig servletConfig;
	public void setServletConfig(ServletConfig arg0) {
		this.servletConfig = arg0;
		
	}

	//controller开始
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
	public void smartUploadFile(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		
		//设置上传文件的保存路径
		String saveFilePath = "D:/smartupload";
		File file = new File(saveFilePath); 
		if(!file.exists()){
			file.mkdirs();  	
		}
		
		SmartUpload smartUpload = new SmartUpload();
		//初始化对象
		smartUpload.initialize(servletConfig, request, response);
		
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
			if(e.getMessage().indexOf("1015")!=-1){
				result = "上传失败：上传文件类型不正确！";
			}else if (e.getMessage().indexOf("1010")!=-1) {
				result = "上传失败：上传文件类型不正确！";
			}else if (e.getMessage().indexOf("1105")!=-1) {
				result = "上传失败：上传文件大小大于允许的最大值！";
			}else if (e.getMessage().indexOf("1110")!=-1) {
				result = "上传失败：上传文件总大小大于允许的最大值！";
			}
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		
	}

	//使用fileupload上传文件
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
					System.out.println("上传文件名:"+name);
					String id = UUID.randomUUID().toString();
					
					name = id+name;
					System.out.println("随机生成的文件名："+name);
					
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
