package com.classloader;

public class Sample {
	public Sample() {
		//输出加载该类的类加载器
		System.out.println("加载Sample类的加载器是:"+this.getClass().getClassLoader());
		
	}
}
