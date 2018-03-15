package com.ldw.familyTree.jsonTest;

import java.util.HashMap;
import java.util.Map;

import javax.json.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonDemo {

	public static void main(String[] args) {
		JsonTest();
		createJSONmap();
		createJSONbybean();
		

	}

	private static void JsonTest() {
		JSONObject min = new JSONObject();
		
		try {
			min.put("name", "����");
			min.put("age", "22");
			min.put("sex", "female");
			min.put("skill", new String[]{"����","����"});
			min.put("marital status", "married");
			System.out.println(min.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//ʹ��hashmap����JSON
	private static void createJSONmap() {
		Map<String, Object> min = new HashMap<String, Object>();
		min.put("name", "����");
		min.put("age", "22");
		min.put("sex", "female");
		min.put("skill", new String[]{"����","����"});
		min.put("marital status", "married");
		System.out.println(new JSONObject(min).toString());
		
	}
	
	//ʹ��Java bean ����JSON����
	private static void createJSONbybean() {
		
		Person min = new Person();
		min.setName("����");
		min.setAge(22);
		min.setSex("female");
		min.setMarital_status("married");
		min.setSkills(new String[]{"����","����"});
		System.out.println(new JSONObject(min).toString());
		
	}

}
