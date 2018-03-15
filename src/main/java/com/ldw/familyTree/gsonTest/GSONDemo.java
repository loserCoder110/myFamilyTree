package com.ldw.familyTree.gsonTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ldw.familyTree.jsonTest.Person;

public class GSONDemo {

	public static void main(String[] args) {
		//使用Javabean生成Gson数据--->JSON 
		Person min = new Person();
		min.setName("赵敏");
		min.setAge(22);
		min.setSex("female");
		min.setMarital_status("married");
		min.setSkills(new String[]{"做饭","功夫"});
		
		min.setIgnore("这是一个用transient修饰的属性，使用Gson时不可见");
		
		//GSON的一些个性化的操作(数据格式更好看)
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();	
		Gson gson = gsonBuilder.create();
		
		System.out.println(gson.toJson(min).toString());

	}

}
