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
		//����JSON�Ĺؼ�
		String context = FileUtils.readFileToString(file, "utf-8");
		try {
			System.out.println(context);
			JSONObject jsonObject =new JSONObject(context);
			System.out.println("������JSONΪ��"+jsonObject.toString());
			
			//��ȡJSON�е��ֶ�
			System.out.println("�����ǣ�"+jsonObject.getString("name"));
			
			System.out.println("������:"+jsonObject.getInt("age"));
			
			System.out.println("��û�е����ߣ�"+jsonObject.getString("the_third_one"));
			
			//����JSON�е�����
			JSONArray jsonArray = jsonObject.getJSONArray("skills");
			for(int i=0;i<jsonArray.length();i++){
				System.out.println("����"+(i+1)+":"+jsonArray.get(i));
			}
			
			//ʹ��isNUll�������ж�JSON�����Ƿ�Ϊ��
			if (!jsonObject.isNull("nickname")) {
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new JSONException("error");
		}
		

	}

}
