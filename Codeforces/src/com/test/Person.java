package com.test;

public class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		System.out.println("调用有参的构造函数Person(String name, int age)");
	}
	public Person(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = 0;
		System.out.println("调用有参的构造函数Person(String name)");
	}
	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("调用无参的构造函数");
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	private void say(String str){
		System.out.println(str+"调用私有say()");
	}
	
}
