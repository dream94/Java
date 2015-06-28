package com.entity;

public class User {
	private String name;
	private String pwd;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
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
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
