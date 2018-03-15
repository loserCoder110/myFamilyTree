package com.ldw.familyTree.gsonTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ldw.familyTree.jsonTest.Person;

public class GSONDemo {

	public static void main(String[] args) {
		//ʹ��Javabean����Gson����--->JSON 
		Person min = new Person();
		min.setName("����");
		min.setAge(22);
		min.setSex("female");
		min.setMarital_status("married");
		min.setSkills(new String[]{"����","����"});
		
		min.setIgnore("����һ����transient���ε����ԣ�ʹ��Gsonʱ���ɼ�");
		
		//GSON��һЩ���Ի��Ĳ���(���ݸ�ʽ���ÿ�)
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();	
		Gson gson = gsonBuilder.create();
		
		System.out.println(gson.toJson(min).toString());

	}

}
