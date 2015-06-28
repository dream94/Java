package com.jni;

public class Test1 {
	public native void sayHello();
	static{
		System.loadLibrary("ConsoleApplication2");        //加载C++生成的dll文件
	}
	public static void main(String[] args) {
		Test1 k = new Test1();
		k.sayHello();
	}

}
