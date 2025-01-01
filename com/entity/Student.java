package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "newstudent")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Will auto increment the id field
	private int id;

//	change the name of field name to fullName
	@Column(name = "FullName")
	private String name;
	private long phone;
	private int age;

//	No argument constructor 
	public Student() {

	}

//	Parameterized constructor 
	public Student(int id, String name, long phone, int age) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

//	Public getters and setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
}
