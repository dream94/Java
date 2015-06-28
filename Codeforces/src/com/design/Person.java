package com.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Person implements xiangqin{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public void see(){
		System.out.println(name+"ÕıÔÚÏàÇ×");
	}
}
