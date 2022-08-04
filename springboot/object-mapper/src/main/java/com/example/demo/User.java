package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	private String name;
	private int age;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User() {
		this.name = null;
		this.age = 0;
		this.phoneNumber = null;
	}
	
	public User(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
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

//	public User getDefaultUser() {
//		return new User("default", 0);
//	}
	// object mapper가 참조하는 클래스는 get method를 활용하기 때문에 get을 빼야한다.
	public User defaultUser() {
		return new User("default", 0, "010-0000-0000");
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
	}

}
