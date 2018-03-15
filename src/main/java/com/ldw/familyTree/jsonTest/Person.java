package com.ldw.familyTree.jsonTest;

import com.google.gson.annotations.SerializedName;

public class Person {
	
	@SerializedName("NAME")
	private String name;
	private int age;
	private String[] skills;
	private String sex;
	private String marital_status;
	
	//gson，tansient关键字用来瘦身？
	private transient String ignore;
	
	public String getIgnore() {
		return ignore;
	}
	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	
	

}
