package com.ldw.familyTree.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userLoginController")
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String loginDirect(HttpServletRequest request,String username,String password){
		
		System.out.println(username+"----"+password);
		System.out.println("���Գɹ�");
		
		return null;
		
	}
	
	@RequestMapping("/toUploadPic")
	public String toUploadPic(){
		
		return "uploadFile/uploadPic";
		
	}
	
	@RequestMapping("/register")
	public String userRegister(){
		System.out.println("����ע��ҳ��");
		return "login/register";
	}
	
	

}
