package com.jni;

public class Test1 {
	public native void sayHello();
	static{
		System.loadLibrary("ConsoleApplication2");        //����C++���ɵ�dll�ļ�
	}
	public static void main(String[] args) {
		Test1 k = new Test1();
		k.sayHello();
	}

}
