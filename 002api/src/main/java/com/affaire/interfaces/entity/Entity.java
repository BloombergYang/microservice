package com.affaire.interfaces.entity;

public class Entity implements java.io.Serializable{

	private static final long serialVersionUID = 4699862600599057658L;
	
	private Long id;
	private String name;
	private Integer age;
	private String describe;
	
	
	
	public Entity() {
	}
	public Entity(Long id, String name, Integer age, String describe) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.describe = describe;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	

}
