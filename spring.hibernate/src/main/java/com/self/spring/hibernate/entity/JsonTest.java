package com.self.spring.hibernate.entity;

public class JsonTest {
	private String name;
	private Integer num;
	private String date;
	
	// getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public JsonTest() {
	}
	public JsonTest(String name, Integer num, String date) {
		super();
		this.name = name;
		this.num = num;
		this.date = date;
	}
	
	
	
	
}
