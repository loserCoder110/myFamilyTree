package com.ldw.familyTree.jsonTest;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParseJSON {

	public static void main(String[] args) throws IOException, JSONException {
		
		File file = new File(ParseJSON.class.getResource("jsonTest.json").getPath());
		//解析JSON的关键
		String context = FileUtils.readFileToString(file, "utf-8");
		try {
			System.out.println(context);
			JSONObject jsonObject =new JSONObject(context);
			System.out.println("解析的JSON为："+jsonObject.toString());
			
			//获取JSON中的字段
			System.out.println("姓名是："+jsonObject.getString("name"));
			
			System.out.println("年龄是:"+jsonObject.getInt("age"));
			
			System.out.println("有没有第三者："+jsonObject.getString("the_third_one"));
			
			//解析JSON中的数组
			JSONArray jsonArray = jsonObject.getJSONArray("skills");
			for(int i=0;i<jsonArray.length();i++){
				System.out.println("技能"+(i+1)+":"+jsonArray.get(i));
			}
			
			//使用isNUll方法来判断JSON属性是否为空
			if (!jsonObject.isNull("nickname")) {
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new JSONException("error");
		}
		

	}

}
